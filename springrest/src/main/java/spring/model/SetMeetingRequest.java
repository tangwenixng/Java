package spring.model;

import org.slf4j.Logger;

/**
 * Created by twx on 2017/8/22.
 */
public class SetMeetingRequest extends SecurityContext {
    private String meetingKey;
    private String confName;
    private String startDate;
    private int duration;

    public String getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(String meetingKey) {
        this.meetingKey = meetingKey;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
            if (meetingKey==""){
                logger.error("meetingKey is null");
                return false;
            }
            if (confName==""){
                logger.error("confName is null");
                return false;
            }

            if (duration<0){
                logger.error("duration < 0");
                return false;
            }
            return true;
        }
        return false;
    }
}
