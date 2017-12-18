import os
import sys
def filter_compare(dirname):

  for filename in os.listdir(dirname):

    if "METASTORE" not in filename:
      continue
    filename = dirname + "/" + filename
    print "Looking in file\t" + filename

    file = open(filename, 'r')
    search_batch = True
    previous_value = -1
    previos_text = ""
    old_hr = -1
    old_min = -1
    old_sec = -1
    old_msec = -1
    for f in file:
      if search_batch and "UPDATE `NOTIFICATION_SEQUENCE`" in f:
        print "ERROR: Expected Batch Statement\t" + str(previous_value) + "\t text:\t" + previos_text

      if search_batch != True and "BATCH [INSERT INTO `NOTIFICATION_LOG`" in f:
        print "ERROR: Expected Update Statement\t" + str(previous_value) + "\t text:\t" + previos_text

      if "BATCH [INSERT INTO `NOTIFICATION_LOG`" in f:
        temp = f[f.index("VALUES (") + 8:len(f) - 3].split(",")[3]
        hms_notificaiton_id = int(temp[1:len(temp) - 1])
        if len(temp) != 9:
          print "ERROR VALUE " + temp
        x = f[:f.index("DEBUG")][11:].split(":")
        old_hr = int(x[0])
        old_min = int(x[1])
        old_temp = x[2].split(",")
        old_sec = int(old_temp[0])
        old_msec = int(old_temp[1])
        previous_value = int(hms_notificaiton_id)
        previos_text = f
        search_batch = False

      if "UPDATE `NOTIFICATION_SEQUENCE`" in f:
        longstring1 = "UPDATE `NOTIFICATION_SEQUENCE` SET `NEXT_EVENT_ID`="
        longstring2 = " WHERE"
        temp = f[f.index(longstring1) + len(longstring1): f.index(longstring2)]
        hms_notificaiton_id = temp[1:len(temp) - 1]

        x = f[:f.index("DEBUG")][11:].split(":")
        new_hr = int(x[0])
        new_min = int(x[1])
        new_temp = x[2].split(",")
        new_sec = int(new_temp[0])
        new_msec = int(new_temp[1])

        if new_hr > old_hr:
          sys.exit("Hour apart\tprev text" + previos_text + "\tcurrent text\f" + f)
        elif new_min > old_min:
          sys.exit("Min apart\tprev text" + previos_text + "\tcurrent text\f" + f)
        elif new_sec > old_sec + 2:
          sys.exit("Sec apart\tprev text" + previos_text + "\tcurrent text\f" + f)
        previous_value = int(hms_notificaiton_id)
        previos_text = f
        search_batch = True

if __name__ == "__main__":
  dirName = "/Users/amishra/Documents/Cloudera/Support/CDH-61788/20171216/output_metastore_20171215_950PM"
  filter_compare(dirName)