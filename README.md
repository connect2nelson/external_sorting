# External Sorting of integers 

External sorting is a term for a class of sorting algorithms that can handle massive amounts of data. 
This project plans to implement external sorting to sort a list of integers in a large file and the data being sorted 
do not fit into the main memory of a computing device (usually RAM) and instead they must reside in the slower external memory (usually a hard drive).

## Strategy :
The plan is to use the external merge sort algorithm, which sorts chunks that each fit in RAM, then merges the sorted chunks together. 
We first divide the file into runs such that the size of a run is small enough to fit into main memory. 
Then sort each run in main memory using merge sort sorting algorithm. 
Finally merge the resulting runs together into successively bigger runs, until the file is sorted.
