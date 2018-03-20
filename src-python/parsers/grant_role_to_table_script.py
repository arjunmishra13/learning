def grantRoleToTable(numberOfTables, split):
  f = open('/Users/amishra/Scripts/output/grantRoleToTable.txt', 'w')
  r = 1
  for i in range(numberOfTables):
    factor = numberOfTables/split
    if i > r*factor:
      r = r + 1
    f.write(("GRANT ROLE role{} to TABLE table{};\n").format(r, i))
  f.close()


if __name__ == "__main__":
  numberOfTables = 10000
  split = 10
  grantRoleToTable(numberOfTables, split)