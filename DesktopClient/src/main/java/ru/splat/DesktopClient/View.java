package ru.splat.DesktopClient;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import matchstatistic.Statistics;
import matchstatistic.sportstatistictypes.Basketball;
import matchstatistic.sportstatistictypes.Football;
import matchstatistic.sportstatistictypes.Handball;
import matchstatistic.sportstatistictypes.Icehockey;
import matchstatistic.sportstatistictypes.StatisticType;
import matchstatistic.sportstatistictypes.Volleyball;


/**
 * <p>
 *
 * @author Andrey & Ekaterina
 *         <p>
 *         View of MVC
 */
public class View implements Observer
{
    private static final Logger log = LoggerFactory.getLogger(View.class);

    private Shell shell;

    private Display display;

    private Model model;

    private Table table;

    private ViewTable viewTable;


    public ViewTable getViewTable()
    {
        return viewTable = new ViewTable();
    }


    public View(Model model, Shell shell, Display display)
    {
        this.model = model;
        this.shell = shell;
        this.display = display;
    }


    @Override
    public void update(OperationType operation, int matchid)
    {
        if (operation == OperationType.ADDED)
        {
            if (this.viewTable != null)
            {
                Display.getDefault().asyncExec(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        /**
                         * redraw only one line
                         */
                        viewTable.drawTable(matchid);
                    }
                });
                log.info("The information of the match with {} id was updated", matchid);
            }
        }
        if (operation == OperationType.REMOVED)
        {
            /**
             * we don't need it yet
             */
        }
    }


    /**
     * Draws a table
     */
    public class ViewTable
    {
        private Map<Integer, TableItem> matchidItemMap = new HashMap<>();

        private TableItem selectedItem = null;


        private void updateItem(int matchid, TableItem item)
        {
            item.setText(0, "" + matchid);
            item.setText(1, "" + model.getSportTypeForMatchid(matchid));
            String team1Name = model.getTeam1NameForMatchid(matchid);
            if (team1Name == null)
                team1Name = "?";
            String team2Name = model.getTeam2NameForMatchid(matchid);
            if (team2Name == null)
                team2Name = "?";
            item.setText(2, "" + team1Name);
            item.setText(3, "" + team2Name);
            item.setText(4, "" + new Date(model.getStartForMatchid(matchid)));
            matchidItemMap.put(matchid, item);
            log.info("Table with info have been drawn for matchid {}", matchid);
        }


        /**
         * Draws a specific table values for the given object identifier
         *
         * @param matchid Matchid for match or -1 for redrawing all the table
         */
        public void drawTable(int matchid)
        {
            log.info("drawTable for {}", matchid == -1 ? "all items" : matchid);
            if (table == null)
            {
                table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
                table.setLinesVisible(true);
                table.setHeaderVisible(true);

                table.addSelectionListener(new SelectionListener()
                {
                    @Override
                    public void widgetSelected(SelectionEvent e)
                    {
                        selectedItem = (TableItem) e.item;
                    }


                    @Override
                    public void widgetDefaultSelected(SelectionEvent e)
                    {

                    }
                });

                /**
                 * @class SubTableController is private, see at the end
                 */
                table.addListener(SWT.MouseDoubleClick, new SubTableController());

                GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
                data.heightHint = 350;
                data.widthHint = 800;
                table.setLayoutData(data);
                String[] titles = { "matchid", "sport type", "team 1 name", "team 2 name", "start time" };
                for (int i = 0; i < titles.length; i++)
                {
                    TableColumn column = new TableColumn(table, SWT.NONE);
                    column.setText(titles[i]);
                }
                for (int i = 0; i < titles.length; i++)
                {
                    table.getColumn(i).setAlignment(SWT.CENTER);
                    table.getColumn(i).pack();
                }
                table.getColumn(1).setWidth(110);
                table.getColumn(2).setWidth(200);
                table.getColumn(3).setWidth(200);
                table.getColumn(4).setWidth(225);
            }
            /**
             * if @matchid == -1 then redraw all the table else redraw only one line for match with that matchid
             */
            if (matchid == -1)
            {
                // com.google.common.collect.Table<Integer, Timestamp, ProviderPackage> modelTable =
                table.removeAll();
                for (Integer matchId : model.getAllMatchid())
                {
                    TableItem item = new TableItem(table, SWT.NONE);
                    updateItem(matchId, item);
                }
            }
            else
            {
                TableItem item = null;
                /**
                 * if item for that matchid doesn't exist then creating it
                 */
                if (!matchidItemMap.containsKey(matchid))
                {
                    item = new TableItem(table, SWT.NONE);
                    matchidItemMap.put(matchid, item);
                    log.info("Item with matchid = {} added", matchid);

                }
                else
                {
                    item = matchidItemMap.get(matchid);
                }

                updateItem(matchid, item);
                log.info("Item with matchid = {} updated", matchid);

            }
            shell.pack();
        }


        /**
         * Class for SubTable with statistics Create new subShell for shell and create new subTable with statistics for
         * subShell
         * 
         * @author Andrey
         *
         */
        private class SubTableController implements Listener
        {
            private Table subTable;

            private Shell subShell;


            @Override
            public void handleEvent(Event event)
            {
                if (subShell == null)
                {
                    log.debug("Creating subShell...");
                    subShell = new Shell(display);
                    subShell.addListener(SWT.Close, new Listener()
                    {
                        @Override
                        public void handleEvent(Event event)
                        {
                            subShell.setVisible(false);
                            event.doit = false;
                        }
                    });
                    GridLayout glSubShell = new GridLayout();
                    subShell.setLayout(glSubShell);
                    glSubShell.numColumns = 1;
                    subShell.open();
                    log.info("subShell was created");
                }

                int currentLineMatchid = Integer.parseInt(selectedItem.getText(0));
                Map<StatisticType, String> statisticValues = new HashMap<>();
                StatisticType[] allStatistics = null;
                switch (model.getSportTypeForMatchid(currentLineMatchid))
                {
                    case FOOTBALL:
                        allStatistics = Football.values();
                        break;
                    case BASKETBALL:
                        allStatistics = Basketball.values();
                        break;
                    case ICE_HOCKEY:
                        allStatistics = Icehockey.values();
                        break;
                    case VOLLEYBALL:
                        allStatistics = Volleyball.values();
                        break;
                    case HANDBALL:
                        allStatistics = Handball.values();
                        break;
                    default:
                        return;
                }
                for (StatisticType st : allStatistics)
                {
                    Statistics statistics = model.getStatisticForMatchid(currentLineMatchid, st);
                    if (statistics != null)
                    {
                        String value1 = statistics.getValue1() == -1 ? "?" : "" + statistics.getValue1();
                        String value2 = statistics.getValue2() == -1 ? "?" : "" + statistics.getValue2();
                        /**
                         * TODO: st.name() -> english(russian?) word like FREE_KICK -> Free kicks(Свободные удары?)
                         */
                        statisticValues.put(st, value1 + "-" + value2);
                    }
                }

                if (subTable != null)
                {
                    subTable.dispose();
                }
                log.debug("Creating subTable...");
                subTable = new Table(subShell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
                subTable.setLinesVisible(true);
                subTable.setHeaderVisible(true);
                GridData subData = new GridData(SWT.FILL, SWT.FILL, true, true);
                subTable.setLayoutData(subData);

                for (StatisticType st : statisticValues.keySet())
                {
                    TableColumn column = new TableColumn(subTable, SWT.NONE);
                    column.setText(st.toString());
                }
                for (int i = 0; i < statisticValues.size(); i++)
                {
                    subTable.getColumn(i).pack();
                }

                TableItem item = new TableItem(subTable, SWT.NONE);
                int ii = 0;
                for (StatisticType st : statisticValues.keySet())
                {
                    item.setText(ii, statisticValues.get(st));
                    ii++;
                }

                subShell.setVisible(true);
                subShell.pack();
                log.info("subTable was created");
            }
        }
    }
}
