import sys
import os
from datetime import datetime

TRYING_TO_OPEN_CONNECTION_TO_METASTORE = "Trying to connect to metastore with URI"
OPENED_A_CONNECTION_TO_METASTORE = "Opened a connection to metastore"
CONNECTED_TO_METASTORE = "Connected to metastore"
CLOSED_A_CONNECTION_TO_METASTORE = "Closed a connection to metastore"
INFO = "INFO"

def analyze_time_to_open_connections_dir(after_str, end_str, inputDir, outputfile):
  for fileName in os.listdir(inputDir):
    inputFile = open(fileName, 'r')
    analyze_time_to_open_connections(after_str, end_str, inputFile, outputfile)

def analyze_time_to_open_connections(after_str, end_str, inputFile, outputfile):
    connection_list = {}
    start_after_str = False
    if len(after_str) > 0:
      start_after_str = True

    stop_after_end_str = False
    if len(end_str) > 0:
      stop_after_end_str = True

    global_index = 0
    current_trigger_index = 0
    current_open_index = 0
    current_connected_index = 0

    for row in open(inputFile, 'r'):

      if stop_after_end_str and end_str in row:
        print "Hit end str:\t" + end_str
        break

      if start_after_str and after_str not in row:
        continue
      else:
        start_after_str = False
        if TRYING_TO_OPEN_CONNECTION_TO_METASTORE in row:
          time_ms_str =  row[:row.index(INFO) - 1]
          time_ms = get_time_in_ms(time_ms_str)
          connOj = ConnectionTime()
          connOj.set_time_to_trigger(time_ms)
          connOj.set_trigger_str(time_ms_str)
          connection_list[global_index] = connOj
          global_index = global_index + 1

        if OPENED_A_CONNECTION_TO_METASTORE in row:
          time_ms_str =  row[:row.index(INFO) - 1]
          time_ms = get_time_in_ms(time_ms_str)
          if connection_list.has_key(current_trigger_index):
            connObj = connection_list[current_trigger_index]
            connObj.set_time_to_open(time_ms)
            connObj.set_open_str(time_ms_str)
            current_trigger_index = current_trigger_index + 1

        if CONNECTED_TO_METASTORE in row:
          time_ms_str =  row[:row.index(INFO) - 1]
          time_ms = get_time_in_ms(time_ms_str)
          if connection_list.has_key(current_open_index):
            connObj = connection_list[current_open_index]
            connObj.set_time_to_connect(time_ms)
            connObj.set_connect_str(time_ms_str)
            current_open_index = current_open_index + 1

        if CLOSED_A_CONNECTION_TO_METASTORE in row:
          time_ms_str =  row[:row.index(INFO) - 1]
          time_ms = get_time_in_ms(time_ms_str)
          if connection_list.has_key(current_connected_index):
            connObj = connection_list[current_connected_index]
            connObj.set_time_to_close(time_ms)
            connObj.set_close_str(time_ms_str)
            current_connected_index = current_connected_index + 1

    writeToFile = open(outputfile, 'w')
    for key in sorted(connection_list):
      print_str = connection_list[key].to_string_verbose() + "\n";
      print print_str
      writeToFile.write(print_str)
    writeToFile.close()

def get_time_in_ms(time_ms_str):
  dt_obj = datetime.strptime(time_ms_str, '%Y-%m-%d %H:%M:%S,%f').strftime(
    '%s.%f')
  time_ms = int(float(dt_obj) * 1000)
  return time_ms

class ConnectionTime:
  trigger_str = ""
  open_str = ""
  connect_str = ""
  close_str = ""
  time_to_trigger = 0
  time_to_open = 0
  time_to_connect = 0
  time_to_close = 0

  def set_trigger_str(self, trigger_str):
    self.trigger_str = trigger_str

  def set_open_str(self, open_str):
    self.open_str = open_str

  def set_connect_str(self, connect_str):
    self.connect_str = connect_str

  def set_close_str(self, close_str):
    self.close_str = close_str

  def set_time_to_trigger(self, time_to_trigger):
    self.time_to_trigger = time_to_trigger

  def set_time_to_open(self, time_to_open):
    self.time_to_open = time_to_open

  def set_time_to_connect(self, time_to_connect):
    self.time_to_connect = time_to_connect

  def set_time_to_close(self, time_to_close):
    self.time_to_close = time_to_close

  def get_time_to_trigger(self):
    return self.time_to_trigger

  def get_time_to_open(self):
    return self.time_to_open

  def get_time_to_connect(self):
    return self.time_to_connect

  def get_time_to_close(self):
    return self.time_to_close

  def get_trigger_str(self):
    return self.trigger_str

  def get_open_str(self):
    return self.open_str

  def get_connect_str(self):
    return self.connect_str

  def get_close_str(self):
    return self.close_str

  def get_duration_to_open(self):
    return self.time_to_open - self.time_to_trigger

  def get_duration_to_connect(self):
    return self.time_to_connect - self.time_to_trigger

  def get_duration_to_close(self):
    return self.time_to_close - self.time_to_connect

  def to_string(self):
    return str(self.get_duration_to_open()) + "\t" + str(self.get_duration_to_connect()) + "\t" + str(self.get_duration_to_close())

  def to_string_verbose(self):
    return self.get_trigger_str() + "\t" + \
           self.get_open_str() + "\t" + \
           self.get_connect_str() + "\t" + \
           self.get_close_str() + "\t" + \
           str(self.get_duration_to_open()) + "\t" + str(self.get_duration_to_connect()) + "\t" + str(self.get_duration_to_close())

  def to_string_verbose_with_timestamp(self):
    return self.get_trigger_str() + "\t" + str(self.get_time_to_trigger()) + "\t" + \
           self.get_open_str() + "\t" + str(self.get_time_to_open()) + "\t" + \
           self.get_connect_str() + "\t" + str(self.get_time_to_connect()) + "\t" + \
           self.get_close_str() + "\t" + str(self.get_time_to_close()) + "\t" + \
           str(self.get_duration_to_open()) + "\t" + str(self.get_duration_to_connect()) + "\t" + str(self.get_duration_to_close())
if __name__ == "__main__":
  inputDir = "/Users/amishra/Documents/Cloudera/Support/CDH-72834/latest_logs/"
  # inputFile = "/Users/amishra/Documents/Cloudera/Support/CDH-72834/latest_logs/hadoop-cmf-sentry-SENTRY_SERVER-srvcloirlsk00.analytics1.santanderuk.pre.corp.log+(1).out"
  inputFile = "/Users/amishra/Documents/Cloudera/Support/CDH-73149/sentry/hadoop-cmf-sentry-SENTRY_SERVER-mid1-db138hd-3.hd.docomodigital.com.log.out"
  outputfile = "/Users/amishra/Documents/Cloudera/Support/CDH-73149/sentry_connection_time_analysis.txt"
  # after_str = "2018-09-11 07:00:59,704 INFO org.apache.sentry.service.thrift.SentryHMSClient: Request full HMS snapshot"
  after_str = ""
  # end_str = "2018-09-11 12:38:14,790 INFO org.apache.sentry.service.thrift.SentryHMSClient: Obtained full HMS snapshot"
  end_str = ""
  # analyze_time_to_open_connections_dir(after_str, end_str, inputDir, outputfile)
  analyze_time_to_open_connections(after_str, end_str, inputFile, outputfile)