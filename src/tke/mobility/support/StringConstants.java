/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tke.mobility.support;

/**
 *
 * @author
 */
public interface StringConstants {

    public static String reportNames = "Choose Report; <-------EBS------->;Debriefs sent from Mobile;Repair/Construction Tickets Posted;Repair/Construction ToolBox Talks tickets posted;Check Duplicate SIT (MS2.0);Time Summary;<-------SVG------->;Tickets accepted by Mobile;Ticket Status (BC);Ticket Debriefs (BC);<-------ANT------->;Health Check;AMP Device Connectivity";//;Tickets sent to Mobile from SVG
    public static String RepairToolBoxTicketsPosted = "SELECT mec.TRANSACTION_ID,MEC.ATTRIBUTE1,MEC.ATTRIBUTE2,MEC.ATTRIBUTE3,MEC.ATTRIBUTE4,mec.PROJECT_ID"
            + ",mec.PERSON_ID,mec.COST_CENTER_ID ,mec.CREATION_DATE ,mec.DEVICE_ID ,mec.EMPLOYEE_NUMBER,mec.FIRST_NAME,mec.LAST_NAME"
            + ",mec.PROCESSED ,mec.ORGANIZATION_ID ,mec.POST_TO_PDA,mec.FORCED_UNSCHEDULE FROM bolinf.tke_tp_cus_xd_05_co_mec_aud mec WHERE mec.post_to_pda = 'Y'";
    public static String MechanicDebriefs = "Select creation_date,entry_source ,source,line_type,expenditure_type,service_activity_code,project_id,proj_desc,description,task_id,task,task_name,task_desc"
            + ",incident_task_id,week_ending_date,activity_date,start_time,end_time,duration,quantity,uom_code,amount,attribute9"
            + ",attribute14,attribute15 as DeviceId,task_status,serial_number,building_name,nick_name,item_description,status_ap,status_pa,status_pay,status_cs  from apps.tke_tp_cus_cd_14_lines_v  where 1 =1  ";
    public static String TicketsSentToDeviceFromSVG = "select to_char(w.createddt,'dd-MON-yy HH:MM')  as CreatedDate, imp.updateddt as LastUpdated,w.id as OracleId, ISA.SITE_LASTEBSDEBRIEFDATE as LastDebriefDate,WOA.WO_TASKNAME as Task,WOA.WO_UNITNAMES as Units,ISA.SITE_TKEROUTES as TKERoute,"
            + "ip.installsitename as InstallSite from imp_dex_tix imp, svc_work_orders w,svc_work_order_attrs woa, ipcs_install_site ip , svc_projects prj,IPCS_INSTALL_SITE_ATTRS  isa where 1=1 "
            + "and imp.workorderhostid = w.id and ip.installsiteid = w.instsite_fk and PRJ.pk = W.PROJECT_FK and WOA.WORKORDERID = w.pk and ISA.INSTSITEID  = W.INSTSITE_FK ";
    public static String PopulateDateCriteria = "Today;7 days ago;2 weeks ago;1 month ago;Let me enter dates";
    public static String PopulateEmployees = "select  e.name ||' ('|| e.id||':'|| a.emp_tkeroutes ||')' as Employee from ipcs_employees e join ipcs_employee_attrs a on A.EMPLOYEEID = e.pk where E.ACTIVE ='y' and e.employee_type_fk  <> 5 ORDER BY 1";
    public static String TicketsPostedForRepCon = "SELECT   req.TRANSACTION_ID,req.TICKET_TYPE,req.TASK_NUMBER,req.TOTAL_DURATION,req.BRANCH_NUMBER,req.SR_NUMBER,req.DISPATCH_AREA,req.ACCESS_NOTE,req.DISPATCH_REQUIRED,req.duration"
            + ",req.CREATION_DATE,req.INSTALL_LOCATION_ID,req.IS_SOUNDNET,req.MECHANIC_EMP_REFERENCE,req.ORG_ID,req.SCHEDULED_START_DATE"
            + ",req.SCHEDULED_END_DATE,req.STATUS_CODE ,req.STATUS_MESSAGE FROM bolinf.tke_tp_cus_xd_05_sv_req_aud req  WHERE 1=1 AND req.status_code='SUCCESS'";
    public static String AntennaDeviceConnectivity
            = " Select PersonId,UserName,Branch,ConnectedStatus"
            + ",to_char(ConnectedTime0,'dd-MON-yy HH:MM') as EventConnectedTime"
            + ",to_char(DisConnectedTime,'dd-MON-yy HH:MM') as EventDisconnectedTime"
            + ",Server"
            + ",ConnectedApplication as AppId"
            + ",DeviceId"
            + " FROM"
            + "(select distinct"
            + " s.subscriberId as PersonId"
            + ",s.pkey"
            + ",d.subscriberfk"
            + ",s.FirstName ||' '||s.lastName as UserName"
            + ",grp.description as Branch "
            + ",s.Email"
            + ",s.Status"
            + ",case when ch.state =0 then NULL else ch.EventTime   end as ConnectedTime0"
            + ",ch_1.EventTime as ConnectedTime1"
            + ",(select eventtime from ANTCFG.OWCONNHISTORY"
            + " where 1=1 and state = 0  and subscriberfk = s.pkey and eventtime = ch.eventtime) as DisConnectedTime"
            + ",ch.Server"
            + ",case  when ch.state =1 then 'Online' else 'Offline' end as ConnectedStatus"
            + ",CH.APPID as ConnectedApplication"
            + ",CH.DEVICEID"
            + ",s.groupfk"
            + " from ANTCFG.OWSUBSCRIBER s"
            + ",ANTCFG.OWCONNHISTORY ch"
            + ",ANTCFG.OWCONNHISTORY ch_1"
            + ",ANTCFG.OWDEVICE d"
            + ",ANTCFG.OWGROUP grp"
            + " where 1=1"
            + " and d.deviceid = ch.deviceid"
            + " and d.subscriberfk  = s.pkey"
            + " and ch.pkey = ch_1.pkey"
            + " and grp.pkey = s.groupfk "
            + " and s.status = 'AC' ";

    public static String TicketHistory = "select SEQUENCEID, TICKETID, STATUS, SOURCE, to_char(RAWXML) as RAWXML, ODISTATUS, MWSTATUS, "
            + "EBSSTATUS, MESSAGE, PDAPERSONID, DEVICEID, APPID, CREATEDBY, CREATIONDATE,"
            + "LASTUPDATEDBY, LASTUPDATEDATE, LASTUPDATELOGIN, REQUESTID, BATCHID, WEBSERVICEID,"
            + "RECORD_STATUS, ATTEMPTS from ticketstatus_db where 1=1 ";
    public static String BCDebriefs = "select distinct dbs.*,d.* from ANTINTG.DBLINESEQUENCE dbs join ANTINTG.DEBRIEFLINE d on D.HEADERID = dbs.headerid"
            + " and dbs.mechanicid = d.pdapersonid ";
    public static String PollingStopped = "SELECT * FROM tke_tp_cus_xd_05_mw_emppda_aud ";
    public static String TicketsAcceptedByDevice = "SELECT \n" +
"TimeWindowStart\n" +
",TW\n" +
",TicketId\n" +
",\"Site Name\"\n" +
",Units\n" +
",Employee\n" +
",PersonId\n" +
",TicketStatus\n" +
",TicketType\n" +
"FROM\n" +
"            (select \n" +
"                     TO_DATE (\n" +
"                            (LPAD (\n" +
"                                SUBSTR (\n" +
"                                   w.start_time_window,\n" +
"                                   (INSTR (w.start_time_window, 'M') + 1),\n" +
"                                   (  (INSTR (w.start_time_window, 'd'))\n" +
"                                    - (INSTR (w.start_time_window, 'M'))\n" +
"                                    - 1)),\n" +
"                                2,\n" +
"                                '0')\n" +
"                             || CASE\n" +
"                                   WHEN (SUBSTR (\n" +
"                                            w.start_time_window,\n" +
"                                            (INSTR (w.start_time_window, 'd')\n" +
"                                             + 1),\n" +
"                                            ( (INSTR (w.start_time_window,\n" +
"                                                      ')'))\n" +
"                                             - (INSTR (w.start_time_window,\n" +
"                                                       'd'))\n" +
"                                             - 1))) LIKE\n" +
"                                           '%h%'\n" +
"                                   THEN\n" +
"                                      LPAD (\n" +
"                                         SUBSTR (\n" +
"                                            (SUBSTR (\n" +
"                                                w.start_time_window,\n" +
"                                                (INSTR (w.start_time_window,\n" +
"                                                        'd')\n" +
"                                                 + 1),\n" +
"                                                ( (INSTR (w.start_time_window,\n" +
"                                                          ')'))\n" +
"                                                 - (INSTR (\n" +
"                                                       w.start_time_window,\n" +
"                                                       'd'))\n" +
"                                                 - 1))),\n" +
"                                            1,\n" +
"                                            (INSTR (\n" +
"                                                (SUBSTR (\n" +
"                                                    w.start_time_window,\n" +
"                                                    (INSTR (\n" +
"                                                        w.start_time_window,\n" +
"                                                        'd')\n" +
"                                                     + 1),\n" +
"                                                    ( (INSTR (\n" +
"                                                          w.start_time_window,\n" +
"                                                          ')'))\n" +
"                                                     - (INSTR (\n" +
"                                                           w.start_time_window,\n" +
"                                                           'd'))\n" +
"                                                     - 1))),\n" +
"                                                'h'))\n" +
"                                            - 1),\n" +
"                                         2,\n" +
"                                         '0')\n" +
"                                   WHEN (SUBSTR (\n" +
"                                            w.start_time_window,\n" +
"                                            (INSTR (w.start_time_window, 'd')\n" +
"                                             + 1),\n" +
"                                            ( (INSTR (w.start_time_window,\n" +
"                                                      ')'))\n" +
"                                             - (INSTR (w.start_time_window,\n" +
"                                                       'd'))\n" +
"                                             - 1))) LIKE\n" +
"                                           '%m%'\n" +
"                                   THEN\n" +
"                                      LPAD (\n" +
"                                         SUBSTR (\n" +
"                                            (SUBSTR (\n" +
"                                                w.start_time_window,\n" +
"                                                (INSTR (w.start_time_window,\n" +
"                                                        'd')\n" +
"                                                 + 1),\n" +
"                                                ( (INSTR (w.start_time_window,\n" +
"                                                          ')'))\n" +
"                                                 - (INSTR (\n" +
"                                                       w.start_time_window,\n" +
"                                                       'd'))\n" +
"                                                 - 1))),\n" +
"                                            1,\n" +
"                                            (INSTR (\n" +
"                                                (SUBSTR (\n" +
"                                                    w.start_time_window,\n" +
"                                                    (INSTR (\n" +
"                                                        w.start_time_window,\n" +
"                                                        'd')\n" +
"                                                     + 1),\n" +
"                                                    ( (INSTR (\n" +
"                                                          w.start_time_window,\n" +
"                                                          ')'))\n" +
"                                                     - (INSTR (\n" +
"                                                           w.start_time_window,\n" +
"                                                           'd'))\n" +
"                                                     - 1))),\n" +
"                                                'm'))\n" +
"                                            - 1),\n" +
"                                         2,\n" +
"                                         '0')\n" +
"                                   ELSE\n" +
"                                      LPAD (\n" +
"                                         (SUBSTR (\n" +
"                                             w.start_time_window,\n" +
"                                             (INSTR (w.start_time_window, 'd')\n" +
"                                              + 1),\n" +
"                                             ( (INSTR (w.start_time_window,\n" +
"                                                       ')'))\n" +
"                                              - (INSTR (w.start_time_window,\n" +
"                                                        'd'))\n" +
"                                              - 1))),\n" +
"                                         2,\n" +
"                                         '0')\n" +
"                                END\n" +
"                             || SUBSTR (\n" +
"                                   w.start_time_window,\n" +
"                                   (INSTR (w.start_time_window, 'y') + 1),\n" +
"                                   4)),\n" +
"                            'MMDDYYYY')\n" +
"                            AS TimeWindowStart,\n" +
"            W.START_TIME_WINDOW as TW ,\n" +
"            w.id as TicketId,\n" +
"            WO_UNITNAMES as Units,\n" +
"            TIX.EMPLOYEEHOSTID  as PersonId,\n" +
"            E.NAME as Employee,\n" +
"            WS.LC_STATE as TicketStatus,\n" +
"            ip.installsitename \"Site Name\",\n" +
"            WOT.WORKORDERTYPENAME as TicketType\n" +
"            from svc_work_orders w,  \n" +
"              imp_dex_Tix tix,\n" +
"              svc_work_order_schedules ws,\n" +
"              ipcs_install_site ip,\n" +
"              ipcs_work_order_types wot,\n" +
"              svc_work_order_attrs woa,\n" +
"              IPCS_EMPLOYEES e\n" +
"              where 1=1\n" +
"              and tix.workorderhostId = W.id\n" +
"              and ws.pk = w.pk\n" +
"              and WS.LC_STATE ='accepted'\n" +
"              and IP.INSTALLSITEID = w.instsite_fk\n" +
"              and WOT.pk= w.work_order_type_fk\n" +
"              and WOA.WORKORDERID = w.pk\n" +
"              and e.id = TIX.EMPLOYEEHOSTID)\n" +
"  \n" +
" WHERE 1=1 ";
    public static String HealthCheckOverBooked = "false";
    public static String HealthCheckBusy = "false";
    public static int HealthCheckRunningUOWNum = 20;
    public static int HealthCheckBusyThreads = 20;
    public static int HealthCheckCurrentQueueLength = 3;
    public static String OODConnection = "jdbc:oracle:thin:@AUOHSTHYK10.oracleoutsourcing.com:10010:PTHYKI";
    public static String SVGConnection = "jdbc:oracle:thin:@vmohsthyk006.oracleoutsourcing.com:10010:PTHY7T";
    public static String ANTConnection = "jdbc:oracle:thin:@auohsthyk43.oracleoutsourcing.com:10010:PTHYKT";
    public static String ANTINTGConnection = "jdbc:oracle:thin:@auohsthyk43.oracleoutsourcing.com:10010/PTHYKT.ORACLEOUTSOURCING.COM";
    public static String ProdHealthCheckURL = "http://tkeantennaprod.oracleoutsourcing.com:9090/hc?stats=true&debug=true";
    

}
