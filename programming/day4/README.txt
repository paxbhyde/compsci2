This directory contains the java source files for a data structure representing Lists. A list is a data structure for holding an arbitrary sequence of items. Linked lists and array lists are two common ways to implement lists.

You should implement an array list with class name ArrayList
You should implement a singlely linked list with name SingleLinkList
You should implement a doublely linked list with name DoubleLinkList

Files:
IList.java  - An interface for lists based on the list operations from the 11/29 lecture
ArrayList.java –  ArrayList class implementing IList interface, an array-based list that is resized as needed.
ISLink.java - An interface that your link cells for SingleLinkList must implement
SLink.java  - Implementation for link cells in a singlely linked list.
SingleLinkList.java – Singly-linked list implementation of IList.
IDLink.java - An interface that your link cells for DoubleLinkList must implement
DLink.java – Implementation of link cells in a doubly linked list.
DoubleLinkList.java – A doubly linked list implementation of IList.
Test.java   - A fairly good but incomplete test suite (e.g. insert is not tested well)
TestFailedException.java - An exception thrown when a test failure is detected