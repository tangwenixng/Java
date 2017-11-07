package spring.model;

import org.slf4j.Logger;

import java.util.List;

/**
 * Created by twx on 2017/8/21.
 */
public class CreateMeetingRequest extends SecurityContext{
    private String confName="testName";
    private List<String> emails;
    private int duration=60;
    private String startDate="08/31/2017 10:00:01";

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean checkSelf(Logger logger) {
        boolean parent = super.checkSelf(logger);
        if (parent) {
            if (confName == "") {
                logger.error("confName is null");
                return false;
            }
            if (duration < 0) {
                logger.error("duration lt 0");
                return false;
            }
            if (startDate == "") {
                logger.error("startDate is null");
                return false;
            }
            return true;
        }
        return false;
    }
}
