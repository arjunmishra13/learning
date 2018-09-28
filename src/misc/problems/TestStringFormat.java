package misc.problems;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class TestStringFormat {

  public static class SentryServiceUtil {

    public static String getCurrentTimeStampWithMessage(String logMessage) {
      String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

      if(StringUtils.isBlank(logMessage)) {
        return date;
      }

      return String.format("%s: %s", date, logMessage);
    }
  }

  public static void main(String []args) {
    long snapshotId = 10L;
    long curImgNum = 5L;
    long imgNum = 0L;
    String logMessage = String.format("(%s) A newer full update with image number %d "
        + "is less than requested image number %d. Send full update to HDFS", "PATH", curImgNum, imgNum);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = String.format("Sentry Store has no HMS Notifications. Create Full HMS Snapshot. "
        + "latest sentry notification Id = %d", snapshotId);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = String.format("HDFSSync is enabled and MAuthzPathsMapping table is empty. Need to request a full snapshot", snapshotId);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));


    logMessage = "FULL_UPDATE_TRIGGER" + "initiating full HMS snapshot request";

    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = String.format("First HMS event notification Id = %d is greater than latest Sentry processed"
        + "notification Id = %d + 1. Need to request a full HMS snapshot.", imgNum, curImgNum);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = String.format("Persisting full snapshot for notification Id = %d", snapshotId);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = String.format("Create full snapshot process is complete: snapshot Id %d", snapshotId);
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = "Request full HMS snapshot";
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

    logMessage = "Obtained full HMS snapshot";
    System.out.println(SentryServiceUtil.getCurrentTimeStampWithMessage(logMessage));

  }
}
