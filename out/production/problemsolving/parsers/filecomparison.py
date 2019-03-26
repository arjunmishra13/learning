file1_map = {}
file2_map = {}
def file_comparison(file1, file2):
	read(file1, file1_map)
	read(file2, file2_map)

	for v1 in file1_map:
		if v1 in file2_map.keys():
			file1_map[v1] = file1_map[v1] - 1
			file2_map[v1] = file2_map[v1] - 1

	del_zero_vals(file1_map)
	del_zero_vals(file2_map)

	print_unique_vals(file1, file1_map)
	print_unique_vals(file2, file2_map)


def print_unique_vals(filename, file_map):
	if len(file_map) > 0:
		for f in file_map:
			print filename + "\t" + f + "\n"


def read(file, file_map):
	for f in open(file, 'r'):

		if "\n" in f:
			f = f[:len(f) - 1]
		if f not in file_map.keys():
			file_map[f] = 0

		file_map[f] = file_map[f] + 1

def del_zero_vals(file_map):

	del_keys = []
	for i in file_map:
		if file_map[i] == 0:
			del_keys.append(i)

	for d in del_keys:
		file_map.pop(d)

if __name__ == "__main__":
	file1 = "/Users/amishra/Documents/Cloudera/TestFiles/compare1.txt"
	file2 = "/Users/amishra/Documents/Cloudera/TestFiles/compare2.txt"
	file_comparison(file1, file2)