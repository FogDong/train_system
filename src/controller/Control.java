package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("control")
public class Control extends ActionSupport implements RequestAware, Preparable {

    private String username;
    private String password;
    private String phone;

    private String startStation;
    private String endStation;
    private String trainName;
    private String transferStation;


    private int STsign=-1;
    private int DTsign=-1;
    private int ETsign=-1;



    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    private Map<String, Object> request;


    @Override
    public void setRequest(Map<String, Object> arg0) {
        this.request = arg0;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginjudge() {
        System.out.println(username + "," + password);
        int t = userService.LoginIN(username, password);
        System.out.println(t);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (t == 0) {
            request.setAttribute("loginSuccess","1");
            return SUCCESS;
        } else {
            request.setAttribute("loginSuccess","0");
            return ERROR;
        }
    }

    public String addjude(){
        System.out.println("yizhi");
        int t = userService.addusr(username,password,phone);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (t == 0) {
            request.setAttribute("registerSuccess","1");
            return SUCCESS;
        } else {
            request.setAttribute("registerSuccess","0");
            return ERROR;
        }
    }

    public String liststaple()
    {
        List staples = userService.liststaple(username);
        System.out.println(staples);
        request.put("staples",staples);
        return "list";
    }


    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getTranferStation() {
        return transferStation;
    }

    public void setransferStation(String transferStation) {
        this.transferStation = transferStation;
    }


    public String straighTrain(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("from-place",startStation);
        request.setAttribute("des-place",endStation);
        request.setAttribute("isTransfer", "0");
        System.out.println(request.getParameter("commit"));
        String search = request.getParameter("commit");
        if (search.equals("搜索")) {
            List TrainList = userService.straightList(startStation, endStation);
            request.setAttribute("TrainList",TrainList);
            request.setAttribute("count",TrainList.size());
            return "list";
        } else if (search.equals("最短路径")) {
            List freightList = userService.ShortestWay(startStation,endStation);
            request.setAttribute("TrainList",freightList);
            request.setAttribute("count",freightList.size());
            request.setAttribute("isTransfer", "1");
            return "list";
        }  else if (search.equals("中转搜索")) {
            List transferList = userService.Transfer(startStation,endStation,request.getParameter("transferStation"));
            request.setAttribute("TrainList",transferList);
            request.setAttribute("count",transferList.size());
            request.setAttribute("isTransfer", "1");
            return "list";
        } else {
            List cheaplist = userService.Cheapest(startStation,endStation);
            request.setAttribute("TrainList",cheaplist);
            request.setAttribute("count",cheaplist.size());
            request.setAttribute("isTransfer", "0");
            return "list";
        }
    }


    /*public String transfer()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        List TrainList = userService.Transfer(startStation,endStation,transfer);
        request.setAttribute("TrainList",TrainList);

        return "list";
    }*/


    public String shortest(){
        List freightList = userService.ShortestWay(startStation,endStation);
        System.out.println(freightList);
        request.put("freightList",freightList);
        return "list";
    }

    /*public String cheapest(){
        List cheaplist = userService.CheapWay(startStation,endStation);
        request.put("cheaplist",cheaplist);
        return "list";
    }*/

    public String sort() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String sort = request.getParameter("commit");
        if (sort.equals("出发时间")) {
            this.listByST();
        } else if (sort.equals("到达时间")) {
            this.listByET();
        } else {
            this.listByDT();
        }
        return "list";
    }

    public String listByST()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        List listbyst = userService.listByST(startStation,endStation,STsign);
        request.setAttribute("TrainList",listbyst);
        STsign = -STsign;
        return "list";
    }

    public String listByET()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        List listbyet = userService.listByET(startStation,endStation,ETsign);
        request.setAttribute("TrainList",listbyet);
        ETsign = -ETsign;
        return "list";
    }

    public String listByDT()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        List listbydt = userService.listByDT(startStation,endStation,DTsign);
        request.setAttribute("TrainList",listbydt);
        DTsign = -DTsign;
        return "list";
    }


    @Override
    public void prepare() throws Exception {

    }
}
