package Utils;

public class Cases {

    private String ApiID;
    private String CaseID;
    private String Desc;
    private String Params;

    public String getApiID() {
        return ApiID;
    }

    public void setApiID(String apiID) {
        ApiID = apiID;
    }

    public void setCaseID(String caseID) {
        CaseID = caseID;
    }

    public String getCaseID() {
        return CaseID;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getDesc() {
        return Desc;
    }

    public String getParams(){
        return Params;
    }
    public void setParams(String params) {
        this.Params = params;
    }


    @Override
    public String toString(){
        return "ApiID="+ApiID+",CaseID="+CaseID+",Desc="+Desc+",Params="+Params;
    }
}
