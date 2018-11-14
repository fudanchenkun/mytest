namespace py streamer


struct AppMonitor{
    1: required string appName
    2: required string status
    3: required string nodeName
}

struct APPLog{
    1: required string name
    2: required i64 size
    3: required string mtime
}

exception StreamerRPCException {
    1: required string message
}

service AppMonitorService{
    list<AppMonitor> listStreamingApps() throws (1:StreamerRPCException ex1)
    bool startApp(1:string app_name) throws (1:StreamerRPCException ex1)
    bool stopApp(1:string app_name) throws (1:StreamerRPCException ex1)
    bool updateRegistryConfFromZK(1:string app_name) throws (1:StreamerRPCException ex1)
    list<string> loadAPPLog(1:string app_name, 2:i16 tail_size) throws (1:StreamerRPCException ex1)
    list<APPLog> listAPPLog(1:string app_name, 2:i16 limit) throws (1:StreamerRPCException ex1)
    string downloadAPPLog(1:string name) throws (1:StreamerRPCException ex1)
}