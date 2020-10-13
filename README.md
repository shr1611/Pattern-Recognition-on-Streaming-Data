# Pattern-Recognition-on-Streaming-Data

Problem Statement:
Implement a program in C/C++/Java to list all frequent path-traversal
patterns with increasing size given a minimum support threshold s and a steam of
web-click data. Each web server logs all activities into a stream (or a log file in batch
mode) in the format of tuples, each containing an integer i (as user ID), and a
reference string r (as web URL). A web-click sequence WCS for a user i can be
extract from the web-click data as wcsi = [r1, r2, …, rk]. A maximal forward reference
MFR is a forward reference path without any backward reference. So, each wcsi can
be converted into several MFRs, i.e., wcsi = [mfr1, mfr2, …, mfrj]. The frequent pathtraversal patterns are MFRs with support ≥ s. Your program should support multiple
web-click streams via sockets (each socket contains an IP address or the hostname,
and a port number) and support ad-hoc queries with support threshold s. Both
input and output follow CSV format.

Input:
- The host sockets (address,port) from where the streaming data is coming continuously,
- Support number

Here is the format of input and output

Input from stdin Example:

129.210.16.80, 9999

129.210.16.88, 33333

3

linux10617.scudc.scu.edu, 55555

7

23


Input from Socket Example:
<id>,<url>
  
100, http://<url1.com>

100, http://<url2.com>

200, http://<url3.com>

400, http://<url1.com>

Output shown in this program are:

- Whenever an input from a socket, it is output to stdout immediately. 
- The Web click sequence, and MFRs

