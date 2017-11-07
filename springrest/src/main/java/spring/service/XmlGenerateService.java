package spring.service;

import org.apache.commons.io.FileUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spring.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by twx on 2017/8/21.
 */
@Service("xmlGenerateService")
public class XmlGenerateService {
    private static final Logger logger = LoggerFactory.getLogger(XmlGenerateService.class);

    private Namespace serv = Namespace.getNamespace("serv","http://www.webex.com/schemas/2002/06/service");
    private Namespace meet = Namespace.getNamespace("meet","http://www.webex.com/schemas/2002/06/service/meeting");
    private Namespace ep = Namespace.getNamespace("ep", "http://www.webex.com/schemas/2002/06/service/ep");
    /**
     * 创建会议 xml
     * @param createMeeting
     * @return
     */
    public String createMeetingReq(String template, CreateMeetingRequest createMeeting){
        Document doc = createMeetingDoc(template,createMeeting);
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
     * 修改创建会议的xml 返回doc
     * @param file
     * @param cm
     */
    public  Document createMeetingDoc(String file,CreateMeetingRequest cm) {
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
            logger.error("CreateMeetingDoc jdom error");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(file+" not found");
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
     * 响应xml转成CreateMeetingResponse对象
     * @param respone
     * @return
     */
    public CreateMeetingResponse respone2CreateMeetingResponse(String respone) {
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

    public List<MeetingRecord> response2MeetingRecord(String response) {
        try {
            Document doc = str2doc(response);
            return doc2MeetingRecord(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private CreateMeetingResponse doc2MeetingDetail(Document document) {
        CreateMeetingResponse md = new CreateMeetingResponse();

        Element root = document.getRootElement();
        logger.debug("rootName: "+root.getName());
        String result = root.getChild("header",serv).getChild("response",serv).getChild("result",serv).getText();
        md.setResult(result);
        if (!result.equalsIgnoreCase("SUCCESS")){
            logger.error("create meeting failure");
            return md;
        }
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
        if (!result.equalsIgnoreCase("SUCCESS")){
            logger.error("GetMeetingResponse is failure");
            return gmResponse;
        }
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

    private List<MeetingRecord> doc2MeetingRecord(Document document) {
        List<MeetingRecord> list = new ArrayList<>();
        Element root = document.getRootElement();
        String result = root.getChild("header",serv).getChild("response",serv).getChild("result",serv).getText();
//        mr.setResult(result);
        if (!result.equalsIgnoreCase("SUCCESS")){
//            logger.error("GetMeetingResponse is failure");
            return null;
        }
        Element bodyContent = root.getChild("body",serv).getChild("bodyContent",serv);
        System.out.println(bodyContent.getName());
        //设置会议名称
        List<Element> recordings = bodyContent.getChildren("recording", ep);
        for (Element recording : recordings) {
            String name = recording.getChild("name",ep).getText();
            String cTime = recording.getChild("createTime",ep).getText();
            String downloadUrl = recording.getChild("fileURL",ep).getText();
            MeetingRecord mr = new MeetingRecord();
            mr.setName(name);
            mr.setCreateTime(cTime);
            mr.setDownloadUrl(downloadUrl);
            list.add(mr);
        }
        return list;
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

    public static Document str2doc(String string) throws Exception {
        SAXBuilder buider = new SAXBuilder();
        Document document = buider.build(new StringReader(string));
        return document;
    }


    /**
     * Document 转String
     * @param document
     * @return
     */
    public static String doc2str(Document document) {
        return new XMLOutputter().outputString(document);
    }
}
