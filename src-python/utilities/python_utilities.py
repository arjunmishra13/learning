from datetime import datetime
import time

class PythonUtilities():

  def getDateTime(self, time):
    return datetime.strptime(time, '%Y-%m-%d %H:%M:%S,%f')

def getTimeStamp(self, time):
  return time.mktime(self.getDateTime(time).timetuple())

