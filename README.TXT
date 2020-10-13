# Submission Read-me

    README.txt
--------------------------------------------
Submitted by
Shruti Jagadeesh Bhat
W1587845
--------------------------------------------
Note:
- Socket is entered in <hostname,port> format, no spaces.
- As soon as a socket is entered, the inputs received from the server is displayed one by one continuously.
- If multiple sockets are to be input at once, then please make sure you include the "enter or return" along with the socket data while copying from other text area.
- Anytime the support value can be entered, the output for the data received till the time when support was entered is considered, while inputs keep loading from the server, if any.
--------------------------------------------
--------------------------------------------

Expected output:
--------------------------------------------
[sbhat1@linux10601 P2]$ java P2
Waiting for the std input for P2...
Enter socket in the form <hostname,portNumber> (NO SPACES)
NOTE: For multiple socket entries, make sure you include "Enter (or Return) character" while copying the data from other resource
Linux10622,37574
129.210.16.152,34480
Connected socket(s): Socket[addr=/129.210.16.152,port=34480,localport=36706]

RECEIVED INPUTS from socket(Socket[addr=/129.210.16.152,port=34480,localport=36706]):
7, http://snap.stanford.edu/class/cs246-2019/
Connected socket(s): Socket[addr=Linux10622/129.210.16.152,port=37574,localport=47966]

RECEIVED INPUTS from socket(Socket[addr=Linux10622/129.210.16.152,port=37574,localport=47966]):
3, http://snap.stanford.edu/class/cs246-2019/
7, http://infolab.stanford.edu/~ullman/mmds/ch8.pdf
6, http://snap.stanford.edu/class/cs246-2019/
6, http://snap.stanford.edu/class/cs246-2019/slides/12-graphs2.pdf
9, http://snap.stanford.edu/class/cs246-2019/
9, http://snap.stanford.edu/class/cs246-2019/slides/11-graphs1.pdf
4, http://snap.stanford.edu/class/cs246-2019/
5, http://snap.stanford.edu/class/cs246-2019/
8, http://snap.stanford.edu/class/cs246-2019/
5, http://infolab.stanford.edu/~ullman/mmds/ch5.pdf
7, http://snap.stanford.edu/class/cs246-2019/
11, http://snap.stanford.edu/class/cs246-2019/
7, http://infolab.stanford.edu/~ullman/mmds/ch6.pdf
3, http://snap.stanford.edu/class/cs246-2019/
6, http://snap.stanford.edu/class/cs246-2019/
7, http://snap.stanford.edu/class/cs246-2019/
6, http://snap.stanford.edu/class/cs246-2019/
11, http://snap.stanford.edu/class/cs246-2019/
6, http://snap.stanford.edu/class/cs246-2019/slides/03-lsh.pdf
Connected to Host: Linux10622
Port: 37574
Continue inputting...
Connected to Host: 129.210.16.152
Port: 34480
Continue inputting...

4
Support: 4


WEB CLICK SEQUENCES FOR EACH USER
WCS BY>> 7: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch8.pdf,  http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch6.pdf,  http://snap.stanford.edu/class/cs246-2019/]
WCS BY>> 3: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/]
WCS BY>> 6: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/12-graphs2.pdf,  http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/03-lsh.pdf]
WCS BY>> 9: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/11-graphs1.pdf]
WCS BY>> 4: 
	[ http://snap.stanford.edu/class/cs246-2019/]
WCS BY>> 5: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch5.pdf]
WCS BY>> 8: 
	[ http://snap.stanford.edu/class/cs246-2019/]
WCS BY>> 11: 
	[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/]


MAXIMAL FORWARD REFERENCES FOR EACH USER
MFR BY>> 7: 
	[[ http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch8.pdf], [ http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch6.pdf], [ http://snap.stanford.edu/class/cs246-2019/]]
MFR BY>> 3: 
	[[ http://snap.stanford.edu/class/cs246-2019/], [ http://snap.stanford.edu/class/cs246-2019/]]
MFR BY>> 6: 
	[[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/12-graphs2.pdf], [ http://snap.stanford.edu/class/cs246-2019/], [ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/03-lsh.pdf]]
MFR BY>> 9: 
	[[ http://snap.stanford.edu/class/cs246-2019/,  http://snap.stanford.edu/class/cs246-2019/slides/11-graphs1.pdf]]
MFR BY>> 4: 
	[[ http://snap.stanford.edu/class/cs246-2019/]]
MFR BY>> 5: 
	[[ http://snap.stanford.edu/class/cs246-2019/,  http://infolab.stanford.edu/~ullman/mmds/ch5.pdf]]
MFR BY>> 8: 
	[[ http://snap.stanford.edu/class/cs246-2019/]]
MFR BY>> 11: 
	[[ http://snap.stanford.edu/class/cs246-2019/], [ http://snap.stanford.edu/class/cs246-2019/]]


