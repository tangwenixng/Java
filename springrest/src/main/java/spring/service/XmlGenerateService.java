package spring.service;

import org.apache.commons.io.FileUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.stereotype.Service;
import spring.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by twx on 2017/8/21.
 */
@Service("xmlGenerateService")
public class XmlGenerateService {

    private Namespace serv = Namespace.getNamespace("serv","http://www.webex.com/schemas/2002/06/service");
    private Namespace meet = Namespace.getNamespace("meet","http://www.webex.com/schemas/2002/06/service/meeting");
    /**
     * 创建会议 xml
     * @param createMeeting
     * @return
     */
    public String createMeetingReq(String template, CreateMeetingRequest createMeeting){
        Document doc = getEditCreateMeetingDoc(template,createMeeting);
        return  doc2str(doc);
    }

    /**
     * get会议的xml
     * @param templateFile
     * @param gm
     * @return
     */
    public String getMeetingReq(String templateFile, GetMeetingRequest gm) {
        Document doc = getMeetingDoc(templateFile, gm);
        return doc2str(doc);
    }

    /**
     * 修改会议的requestxml
     * @param templateFile
     * @param sm
     * @return
     */
    public String setMeetingReq(String templateFile, SetMeetingRequest sm) {
        Document doc = setMeetingDoc(templateFile, sm);
        return doc2str(doc);
    }

    public String getListMeetingReq(String templateFile, SecurityContext sc) {
        SAXBuilder builder = new SAXBuilder();
        Document doc=null;
        try {
            doc = builder.build(new File(templateFile));
            //设置头部
            setSecurityContext(doc, sc);
            return doc2str(doc);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 设置用户名和密码
     * @param doc
     * @param sc
     */
    public void setSecurityContext(Document doc, SecurityContext sc) {
        List<Element> securityContext = doc.getRootElement().getChild("header").getChild("securityContext").getChildren();
        //用户名密码
        for (Element c : securityContext) {
            if (c.getName()=="siteName") c.setText(sc.getSiteName());
            else if (c.getName()=="webExID") c.setText(sc.getWebExId());
            else if (c.getName()=="password") c.setText(sc.getPassword());
            System.out.println(c.getText()+" ");
        }
    }

    /**
     * 修改创建会议的xml 返回doc
     * @param file
     * @param cm
     */
    public  Document getEditCreateMeetingDoc(String file,CreateMeetingRequest cm) {
        SAXBuilder builder = new SAXBuilder();
        Document doc=null;
        try {
            doc = builder.build(this.getClass().getResource(file));
            //设置用户名和密码
            setSecurityContext(doc,cm);

            Element root = doc.getRootElement();
            Element bodyContent = root.getChild("body").getChild("bodyContent");
            //会议名称
            Element confName= bodyContent.getChild("metaData").getChild("confName");
            confName.setText(cm.getConfName());

            //与会者
            Element attendees = bodyContent.getChild("participants").getChild("attendees");
            attendees.getChildren().clear();//清空
            List<String> emails = cm.getEmails();
            for (int i=0;i<emails.size();i++) {
                Element attendee = new Element("attendee");

                Element person = new Element("person");

                Element name = new Element("name");
                name.setText("admin");
                person.addContent(name);

                Element email = new Element("email");
                email.setText(emails.get(i));
                person.addContent(email);

                attendee.addContent(person);
                attendees.addContent(attendee);
            }

            //开始时间和持续时长
            Element schedule = bodyContent.getChild("schedule");
            schedule.getChild("startDate").setText(cm.getStartDate());
            schedule.getChild("duration").setText(String.valueOf(cm.getDuration()));

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 修改getMeeting模板 返回doc
     * @param templateFile
     * @param gm
     * @return
     */
    public Document getMeetingDoc(String templateFile, GetMeetingRequest gm) {
        SAXBuilder builder = new SAXBuilder();
        Document doc=null;
        try {
            doc = builder.build(this.getClass().getResource(templateFile));  //new File(templateFile)
            //设置用户名和密码
            setSecurityContext(doc,gm);
            //设置meetingKey
            Element root = doc.getRootElement();
            Element bodyContent = root.getChild("body").getChild("bodyContent");
            bodyContent.getChild("meetingKey").setText(gm.getMeetingKey());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 修改会议模版复制 返回doc
     * @param templateFile
     * @param sm
     * @return
     */
    public Document setMeetingDoc(String templateFile, SetMeetingRequest sm) {
        SAXBuilder builder = new SAXBuilder();
        Document doc=null;
        try {
            doc = builder.build(this.getClass().getResource(templateFile));
            //设置用户名和密码
            setSecurityContext(doc,sm);

            Element bodyContent = doc.getRootElement().getChild("body").getChild("bodyContent");
            //设置会议名称
            bodyContent.getChild("metaData").getChild("confName").setText(sm.getConfName());
            //设置开始时间
            bodyContent.getChild("schedule").getChild("startDate").setText(sm.getStartDate());
            bodyContent.getChild("schedule").getChild("duration").setText(String.valueOf(sm.getDuration()));
            bodyContent.getChild("meetingkey").setText(sm.getMeetingKey());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * Document 转String
     * @param document
     * @return
     */
    public static String doc2str(Document document) {
        return new XMLOutputter().outputString(document);
    }

    /**
     * 响应xml转成CreateMeetingResponse对象
     * @param respone
     * @return
     */
    public CreateMeetingResponse respone2MeetingDetail(String respone) {
        try {
            Document doc = str2doc(respone);
            return  doc2MeetingDetail(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GetMeetingResponse response2GetMeetingResponse(String respone) {
        try {
            Document doc = str2doc(respone);
            return doc2GetMeetingResponse(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SetMeetingResponse response2SetMeetingResponse(String respone){
        return null;
    }

    private CreateMeetingResponse doc2MeetingDetail(Document document) {
        CreateMeetingResponse md = new CreateMeetingResponse();

        Element root = document.getRootElement();
//        System.out.println("rootName: "+root.getName());
        String result = root.getChild("header",serv).getChild("response",serv).getChild("result",serv).getText();
        md.setResult(result);

        Element bodyContent = root.getChild("body",serv).getChild("bodyContent",serv);
        String meetingkey = bodyContent.getChild("meetingkey",meet).getText();
        md.setMeetingKey(meetingkey);
        return md;
    }

    private GetMeetingResponse doc2GetMeetingResponse(Document document) {
        GetMeetingResponse gmResponse = new GetMeetingResponse();
        Element root = document.getRootElement();
        String result = root.getChild("header",serv).getChild("response",serv).getChild("result",serv).getText();
        gmResponse.setResult(result);
        if (!result.equalsIgnoreCase("SUCCESS"))
            return gmResponse;
        Element bodyContent = root.getChild("body",serv).getChild("bodyContent",serv);
        System.out.println(bodyContent.getName());
        //设置会议名称
        String confName = bodyContent.getChild("metaData",meet).getChild("confName",meet).getText();
        gmResponse.setConfName(confName);
        //设置开始日期
        String startdate = bodyContent.getChild("schedule",meet).getChild("startDate",meet).getText();
        gmResponse.setStartDate(startdate);
        //设置持续时长
        String duration = bodyContent.getChild("schedule",meet).getChild("duration",meet).getText();
        gmResponse.setDuration(Integer.valueOf(duration));
        //设置状态
        String status = bodyContent.getChild("status",meet).getText();
        gmResponse.setStatus(status);
        //设置meetingKey
        String meetingKey = bodyContent.getChild("meetingkey",meet).getText();
        gmResponse.setMeetingKey(meetingKey);

        String hostkey = bodyContent.getChild("hostKey",meet).getText();
        String eventid = bodyContent.getChild("eventID",meet).getText();
        gmResponse.setHostKey(hostkey);
        gmResponse.setEventId(eventid);
        return  gmResponse;
    }

    private SetMeetingResponse doc2SetMeetingResponse(Document document){
        return null;
    }

    public static void saveXML(Document doc,String savePath) throws IOException {
        XMLOutputter out = new XMLOutputter();
        out.setFormat(Format.getPrettyFormat());
        out.output(doc,new FileOutputStream(savePath));
    }

    public static Document str2doc(String string) throws Exception {
        SAXBuilder buider = new SAXBuilder();
        Document document = buider.build(new StringReader(string));
        return document;
    }

    public String xml2str(String filePath){
        try {
            return  FileUtils.readFileToString(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
