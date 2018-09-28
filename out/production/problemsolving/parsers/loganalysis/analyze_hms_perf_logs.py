import sys

PERFLOG_METHOD_STRING = "PERFLOG method="
START_STRING = "start="
DURATION_STRING = "duration="
FROM_STRING = "from="
def analyze_perf_logs(inputfile, outputfile):

  outputF = open(outputfile, 'w')
  outputF.write("Task,Time\n")
  for i in open(inputfile, 'r'):
    if DURATION_STRING in i and PERFLOG_METHOD_STRING in i:
      start_index = i.index(PERFLOG_METHOD_STRING) + len(PERFLOG_METHOD_STRING)
      end_index = i.index(START_STRING) - 1
      task = i[start_index:end_index]
      start_duration_index = i.index(DURATION_STRING) + len(DURATION_STRING)
      end_duration_index = i.index(FROM_STRING)
      duration_time = i[start_duration_index:end_duration_index]
      outputF.write(task + "," + duration_time + "\n")



  outputF.close();

if __name__ == "__main__":

  inputfile = "/Users/amishra/Documents/Cloudera/Support/CDH-70442/hadoop-cmf-hive-HIVEMETASTORE-sl01plvbim003.wellpoint.com.log.out"
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/GenerateDataScripts/perf_log_analyzer.txt"
  analyze_perf_logs(inputfile, outputfile)