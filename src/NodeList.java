public class NodeList {
    //Head
    private Node head = null;
    public String getHead() {
        this.getAndCalcHead();
        if ( this.head == null ) {
            return null;
        }
        return this.head.data;
    }

    //Tail
    private Node tail = null;
    public String getTail() {
        this.getAndCalcTail();
        if ( this.tail == null ) {
            return null;
        }
        return this.tail.data;
    }

    //CONSTURCTORSSSSSSS         sssssssssssssssssssssss
    public NodeList() {
    }

    public NodeList( Node someNode ) {
        this.setNodeNetwork( someNode );
    }

    public NodeList( String someString ) {
        this.setNodeNetwork( someString );
    }

    public NodeList( String[] someStrings ) {
        this.setNodeNetwork( someStrings );
    }













    //Set NodeNetwork
    public boolean setNodeNetwork_fromHead() {
        return this.setNodeNetwork( this.head );
    }

    public boolean setNodeNetwork_fromTail() {
        return this.setNodeNetwork( this.tail );
    }

    private boolean setNodeNetwork( Node someNode ) {
        if ( someNode == null ) {
            return false;
        }
        Node originalNetworkHead = Node.findHead( someNode );
        String[] originalNetworkData = originalNetworkHead.strings_toFromHead();

        return this.setNodeNetwork( originalNetworkData );
    }

    private boolean setNodeNetwork( String someString ) {
        if ( someString == null ) {
            return false;
        }
        return this.setNodeNetwork( new String[]{ someString } );
    }

    private boolean setNodeNetwork( String[] someStrings ) {
        if ( someStrings == null ) {
            return false;
        }
        Node newHead = Node.stringsToNetwork( someStrings );
        if ( newHead == null ) {
            return false;
        }

        this.head = newHead;
        this.tail = Node.findTail( this.head );
        return true;
    }






    //Network Size
    public int networkSize(){
        int networkSizeRaw = Node.networkSize( this.getAndCalcHead() );
        if ( networkSizeRaw == -1 ) {
            return 0;
        }
        return networkSizeRaw;
    }






    //Calcs
    private Node getAndCalcHead() {
        if ( this.head == null ) {
            if ( this.tail != null ) {
                this.head = Node.findHead( this.getAndCalcTail() );
                return this.head;
            }
            return null;
        }

        if ( this.head.getPrevious() != null ) {
            if ( this.tail != null ) {
                if ( this.tail.next == null ) {
                    this.head = Node.findHead( this.tail );
                    return this.head;
                }
            }
            this.head = Node.findHead( this.head );
            this.tail = Node.findTail( this.head ); //This part only runs if the tail isn't actually a tail, so we need to fix the tail too
            return this.head;
        }

        if ( this.tail == null ) {
            this.tail = Node.findTail( this.head );
        }

        if ( this.tail != null ) {
            if ( this.tail.next != null ) {
                this.tail = Node.findTail( this.head );
            }
//            else if ( !NodeList.isSameNetwork( this.tail, this.head ) ) {
//                this.setNodeNetwork_fromHead();
//            }

        }

        return this.head;
    }

    private Node getAndCalcTail() {
        if ( this.tail == null ) {
            if ( this.head != null ) {
                this.tail = Node.findTail( this.getAndCalcHead() );
                return this.tail;
            }
            return null;
        }

        if ( this.tail.getNext() != null ) {
            if ( this.head != null ) {
                if ( this.head.previous == null ) {
                    this.tail = Node.findTail( this.head );
                    return this.tail;
                }
            }
            this.tail = Node.findTail( this.tail );
            this.head = Node.findHead( this.tail );  //This part only runs if the head isn't actually a head, so we need to fix the head too
            return this.tail;
        }

        if ( this.head == null ) {
            this.head = Node.findHead( this.tail );
        }

        if ( this.head != null ) {
            if ( this.head.previous != null ) {
                this.head = Node.findHead( this.tail );
            }
//            else if ( !NodeList.isSameNetwork( this.head, this.tail ) ) {
//                this.setNodeNetwork_fromTail();
//            }
        }

        return this.tail;
    }

    //Print
    public String print_fromHead() {
        return Node.print_toFromHead( this.getAndCalcHead() );
    }

    public String print_fromTail() {
        return Node.print_toFromTail( this.getAndCalcTail() );
    }

    //Strings - Simple Standalone
    public String[] strings_fromHead() {
        return Node.strings_toFromHead( this.getAndCalcHead(), new StringBuilder() );
    }

    public String[] strings_fromTail() {
        return Node.strings_toFromTail( this.getAndCalcTail(), new StringBuilder() );
    }

    //Strings
    public String[] strings_fromHead( StringBuilder stringBuilder ) {
        return Node.strings_toFromHead( this.getAndCalcHead(), stringBuilder );
    }

    public String[] strings_fromTail( StringBuilder stringBuilder ) {
        return Node.strings_toFromTail( this.getAndCalcTail(), stringBuilder );
    }

    //Stringbuilder - Simple Standalone
    public StringBuilder sb_fromHead() {
        return Node.sb_toFromHead( this.getAndCalcHead(), new StringBuilder() );
    }

    public StringBuilder sb_fromTail() {
        return Node.sb_toFromTail( this.getAndCalcTail(), new StringBuilder() );
    }

    //Stringbuilder
    public StringBuilder sb_fromHead( StringBuilder stringBuilder ) {
        return Node.sb_toFromHead( this.getAndCalcHead(), stringBuilder );
    }

    public StringBuilder sb_fromTail( StringBuilder stringBuilder ) {
        return Node.sb_toFromTail( this.getAndCalcTail(), stringBuilder );
    }


    //Find - public
    public String find_fromHead( String data ) {
        if ( data == null ) {
            return null;
        }
        Node foundNode = this.find_fromHeadNode( data );

        if ( foundNode == null ) {
            return null;
        }
        return foundNode.getData();
    }

    public String find_fromTail( String data ) {
        if ( data == null ) {
            return null;
        }
        Node foundNode = this.find_fromTailNode( data );

        if ( foundNode == null ) {
            return null;
        }
        return foundNode.getData();
    }

    //Find
    private Node find_fromHeadNode( String data ) {
        if ( this.getAndCalcHead() == null || data == null ) {
            return null;
        }
        return Node.find_toTail( this.head, data );
    }

    private Node find_fromTailNode( String data ) {
        if ( this.getAndCalcTail() == null || data == null ) {
            return null;
        }
        return Node.find_toHead( this.tail, data );
    }

    //FindAndInsert - public
    public String findAndInsertAfter_fromHead( String dataInserted, String dataAfterThis ) {
        if ( dataInserted == null || dataAfterThis == null ) {
            return null;
        }

        Node nodeInserted = this.findAndInsertAfter_fromHeadNode( dataInserted, dataAfterThis );
        if ( nodeInserted == null ) {
            return null;
        }
        return nodeInserted.getData();
    }

    public String findAndInsertBefore_fromHead( String dataInserted, String dataBeforeThis ) {
        if ( dataInserted == null || dataBeforeThis == null ) {
            return null;
        }

        Node nodeInserted = this.findAndInsertBefore_fromHeadNode( dataInserted, dataBeforeThis );
        if ( nodeInserted == null ) {
            return null;
        }
        return nodeInserted.getData();
    }

    public String findAndInsertAfter_fromTail( String dataInserted, String dataAfterThis ) {
        if ( dataInserted == null || dataAfterThis == null ) {
            return null;
        }

        Node nodeInserted = this.findAndInsertAfter_fromTailNode( dataInserted, dataAfterThis );
        if ( nodeInserted == null ) {
            return null;
        }
        return nodeInserted.getData();
    }

    public String findAndInsertBefore_fromTail( String dataInserted, String dataBeforeThis ) {
        if ( dataInserted == null || dataBeforeThis == null ) {
            return null;
        }

        Node nodeInserted = this.findAndInsertBefore_fromTailNode( dataInserted, dataBeforeThis );
        if ( nodeInserted == null ) {
            return null;
        }
        return nodeInserted.getData();
    }

    //FindAndInsert
    private Node findAndInsertAfter_fromHeadNode( String dataInserted, String dataAfterThis ) {
        if ( dataInserted == null || dataAfterThis == null ) {
            return null;
        }

        if ( this.getAndCalcHead() == null ) {
            return null;
        }

        Node nodeAfterThis = this.find_fromHeadNode( dataAfterThis );
        if ( nodeAfterThis == null ) {
            return null;
        }
        return this.insertAfter( new Node( dataInserted ), nodeAfterThis );

    }

    private Node findAndInsertBefore_fromHeadNode( String dataInserted, String dataBeforeThis ) {
        if ( dataInserted == null || dataBeforeThis == null ) {
            return null;
        }

        if ( this.getAndCalcHead() == null ) {
            return null;
        }

        Node nodeBeforeThis = this.find_fromHeadNode( dataBeforeThis );
        if ( nodeBeforeThis == null ) {
            return null;
        }
        return this.insertBefore( new Node( dataInserted ), nodeBeforeThis );

    }

    private Node findAndInsertAfter_fromTailNode( String dataInserted, String dataAfterThis ) {
        if ( dataInserted == null || dataAfterThis == null ) {
            return null;
        }

        if ( this.getAndCalcTail() == null ) {
            return null;
        }

        Node nodeAfterThis = this.find_fromTailNode( dataAfterThis );
        if ( nodeAfterThis == null ) {
            return null;
        }
        return this.insertAfter( new Node( dataInserted ), nodeAfterThis );


    }

    private Node findAndInsertBefore_fromTailNode( String dataInserted, String dataBeforeThis ) {
        if ( dataInserted == null || dataBeforeThis == null ) {
            return null;
        }

        if ( this.getAndCalcTail() == null ) {
            return null;
        }

        Node nodeBeforeThis = this.find_fromTailNode( dataBeforeThis );
        if ( nodeBeforeThis == null ) {
            return null;
        }
        return this.insertBefore( new Node( dataInserted ), nodeBeforeThis );

    }

    //FindAndReplace - Public
    public String findAndReplace_fromHead( String dataReplaceWith, String dataReplaced ) {
        if ( dataReplaceWith == null || dataReplaced == null ) {
            return null;
        }
        Node nodeReplaceWith = this.findAndReplace_fromHeadNode( dataReplaceWith, dataReplaced );
        if ( nodeReplaceWith == null ) {
            return null;
        }
        return nodeReplaceWith.getData();
    }

    public String findAndReplace_fromTail( String dataReplaceWith, String dataReplaced ) {
        if ( dataReplaceWith == null || dataReplaced == null ) {
            return null;
        }
        Node nodeReplaceWith = this.findAndReplace_fromTailNode( dataReplaceWith, dataReplaced );
        if ( nodeReplaceWith == null ) {
            return null;
        }
        return nodeReplaceWith.getData();
    }

    //FindAndReplace
    private Node findAndReplace_fromHeadNode( String dataReplaceWith, String dataReplaced ) {
        if ( dataReplaceWith == null || dataReplaced == null ) {
            return null;
        }
        Node nodeReplaceWith = this.findAndInsertBefore_fromHeadNode( dataReplaceWith, dataReplaced );
        if ( nodeReplaceWith == null ) {
            return null;
        }
        if ( nodeReplaceWith.next != null ) {
            this.remove( nodeReplaceWith.next );
        }
        return nodeReplaceWith;
    }

    private Node findAndReplace_fromTailNode( String dataReplaceWith, String dataReplaced ) {
        if ( dataReplaceWith == null || dataReplaced == null ) {
            return null;
        }
        Node nodeReplaceWith = this.findAndInsertAfter_fromTailNode( dataReplaceWith, dataReplaced );
        if ( nodeReplaceWith == null ) {
            return null;
        }
        if ( nodeReplaceWith.previous != null ) {
            this.remove( nodeReplaceWith.previous );
        }
        return nodeReplaceWith;
    }

    //FindAndRemove - Public
    public String findAndRemove_fromHead( String data ) {
        Node nodeRemoved = this.findAndRemove_fromHeadNode( data );
        if ( nodeRemoved == null ) {
            return null;
        }
        return nodeRemoved.getData();
    }

    public String findAndRemove_fromTail( String data ) {
        Node nodeRemoved = this.findAndRemove_fromTailNode( data );
        if ( nodeRemoved == null ) {
            return null;
        }
        return nodeRemoved.getData();
    }

    //Remove - public
    public String removeHead() {
        Node nodeRemoved = this.removeHeadNode();
        if ( nodeRemoved == null ) {
            return null;
        }
        return nodeRemoved.getData();
    }

    public String removeTail() {
        Node nodeRemoved = this.removeTailNode();
        if ( nodeRemoved == null ) {
            return null;
        }
        return nodeRemoved.getData();
    }


    //FindAndRemove - toFrom
    private Node findAndRemove_fromHeadNode( String data ) {
        Node nodeToRemove = this.find_fromHeadNode( data );
        return this.remove( nodeToRemove );
    }

    private Node findAndRemove_fromTailNode( String data ) {
        Node nodeToRemove = this.find_fromTailNode( data );
        return this.remove( nodeToRemove );
    }

    //Remove
    private Node removeHeadNode() {
        return this.remove( this.getAndCalcHead() );
    }

    private Node removeTailNode() {
        return this.remove( this.getAndCalcTail() );
    }

    private Node remove( Node nodeToRemove ) {
        //Is Null
        if ( nodeToRemove == null ) {
            return null;
        }

        //Update Head and Tails
        this.getAndCalcHead();
        this.getAndCalcTail();

        //List Specific
        //Is only node in list
        if ( this.head != null && this.tail != null && this.head.equals( nodeToRemove ) && this.tail.equals( nodeToRemove ) ) {

            this.head.next = null;
            this.head.previous = null;
            this.head = null;

            this.tail.next = null;
            this.tail.previous = null;
            this.tail = null;

            return nodeToRemove;
        }

        //This list's head node
        if ( this.head != null ) {
            if ( this.head.next != null ) {
                if ( nodeToRemove.equals( this.head ) ) {
                    this.head = this.head.next;
                    return Node.helper_remove_head( nodeToRemove );
                }
            }
        }

        //This list's tail node
        if ( this.tail != null ) {
            if ( this.tail.previous != null ) {
                if ( nodeToRemove.equals( this.tail ) ) {
                    this.tail = this.tail.previous;
                    return Node.helper_remove_tail( nodeToRemove );
                }
            }
        }

        //General Removal, middle, head or tail on a different list, ect.
        return nodeToRemove.remove();


    }

    //Insert Public
    public String insertHead( String data ) {
        Node insertedNode = this.insertHeadNode( new Node( data ) );
        if ( insertedNode == null ) {
            return null;
        }
        return insertedNode.getData();
    }

    public String insertTail( String data ) {
        Node insertedNode = this.insertTailNode( new Node( data ) );
        if ( insertedNode == null ) {
            return null;
        }
        return insertedNode.getData();
    }

    //Insert
    private Node insertHeadNode( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.hasZeroNodes() ) {
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.head;
        }

        n = this.insertBefore( n, this.head );

        this.head = n;

        return n;
    }

    private Node insertTailNode( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.hasZeroNodes() ) {
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.tail;
        }

        n = this.insertAfter( n, this.tail );

        this.tail = n;

        return n;
    }

    private void helper_emptyList_make_headAndTail_outOfThisNode( Node n ) {
        //BEFORE USING THIS;
        //-Must have checked the list is empty

        n = this.remove( n );
        n.next = null;
        n.previous = null;

        this.head = n;
        this.head.next = null;
        this.head.previous = null;

        this.tail = n;
        this.tail.next = null;
        this.tail.previous = null;
    }


    private Node insertBefore( Node inserted, Node beforeThis ) {
        try {
            if ( beforeThis.equals( this.getAndCalcHead() ) ) {
                this.head = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertBefore( inserted, beforeThis );

    }

    private Node insertAfter( Node inserted, Node afterThis ) {
        try {
            if ( afterThis.equals( this.getAndCalcTail() ) ) {
                this.tail = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertAfter( inserted, afterThis );

    }


    //Boooooooooooooooooooooooooooooooo
    public boolean hasOneNode() { //List Has
        if ( this.hasZeroNodes() ) {
            return false;
        }
        if ( this.head.equals( this.tail ) ) {
            return true;
        }
        return false;
    }

    public boolean hasZeroNodes() { //List Has
        //Update heads and Tails
        this.getAndCalcHead();
        this.getAndCalcTail();

        if ( this.head == null && this.tail == null ) {
            return true;
        }
        return false;
    }


} //Class
