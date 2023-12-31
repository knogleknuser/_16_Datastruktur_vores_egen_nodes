import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    //Default Test List
    Node node0 = new Node( "0" );
    Node node1 = new Node( "1" );
    Node node2 = new Node( "2" );
    Node node3 = new Node( "3" );
    Node node4 = new Node( "4" );

    //ArrayList
    ArrayList< Node > NodeNs = new ArrayList<>();


    //Second test list
    Node nodeA = new Node( "A" );
    Node nodeB = new Node( "B" );
    Node nodeC = new Node( "C" );
    Node nodeD = new Node( "D" );
    Node nodeE = new Node( "E" );

    //ArrayList
    ArrayList< Node > NodeLs = new ArrayList<>();

    //Array
    String[] stringsTal = {
            "0",
            "1",
            "2",
            "3",
            "4",
    };

    String[] stringsBog = {
            "A",
            "B",
            "C",
            "D",
            "E",
    };


    @BeforeEach
    void setUp() {
        //Set up data structure default
        this.node0.next = this.node1;
        this.node1.previous = this.node0;

        this.node1.next = this.node2;
        this.node2.previous = this.node1;

        this.node2.next = this.node3;
        this.node3.previous = this.node2;

        this.node3.next = this.node4;
        this.node4.previous = this.node3;

        //ArrayList
        this.NodeNs.add( this.node0 );
        this.NodeNs.add( this.node1 );
        this.NodeNs.add( this.node2 );
        this.NodeNs.add( this.node3 );
        this.NodeNs.add( this.node4 );

        //Set up data structure second
        this.nodeA.next = this.nodeB;
        this.nodeB.previous = this.nodeA;

        this.nodeB.next = this.nodeC;
        this.nodeC.previous = this.nodeB;

        this.nodeC.next = this.nodeD;
        this.nodeD.previous = this.nodeC;

        this.nodeD.next = this.nodeE;
        this.nodeE.previous = this.nodeD;

        //ArrayList
        this.NodeLs.add( this.nodeA );
        this.NodeLs.add( this.nodeB );
        this.NodeLs.add( this.nodeC );
        this.NodeLs.add( this.nodeD );
        this.NodeLs.add( this.nodeE );


        //Extra, optional, only 1
        //Loop test
//        this.node0.previous = this.node2;
//        this.node4.next = this.node2;

        //Full Loop Test
//        this.node0.previous = this.node4;
//        this.node4.next = this.node0;
    }

    @Test
    void print_towardsFromHead() {
        this.node0.print_toFromHead();
        this.node1.print_toFromHead();
        this.node2.print_toFromHead();
        this.node3.print_toFromHead();
        this.node4.print_toFromHead();

        this.node0.print_toFromHead();
        this.node1.print_toFromHead();
        this.node2.print_toFromHead();
        this.node3.print_toFromHead();
        this.node4.print_toFromHead();
    }

    @Test
    void print_towardsFromTail() {
        this.node0.print_toFromTail();
        this.node1.print_toFromTail();
        this.node2.print_toFromTail();
        this.node3.print_toFromTail();
        this.node4.print_toFromTail();

        this.node0.print_toFromTail();
        this.node1.print_toFromTail();
        this.node2.print_toFromTail();
        this.node3.print_toFromTail();
        this.node4.print_toFromTail();
    }

    @Test
    void testPrint_towardsFromHead() {
        Node.print_toFromHead( this.node0 );
        Node.print_toFromHead( this.node1 );
        Node.print_toFromHead( this.node2 );
        Node.print_toFromHead( this.node3 );
        Node.print_toFromHead( this.node4 );

        Node.print_toFromHead( this.node0 );
        Node.print_toFromHead( this.node1 );
        Node.print_toFromHead( this.node2 );
        Node.print_toFromHead( this.node3 );
        Node.print_toFromHead( this.node4 );
    }

    @Test
    void testPrint_towardsFromTail() {
        Node.print_toFromTail( this.node0 );
        Node.print_toFromTail( this.node1 );
        Node.print_toFromTail( this.node2 );
        Node.print_toFromTail( this.node3 );
        Node.print_toFromTail( this.node4 );

        Node.print_toFromTail( this.node0 );
        Node.print_toFromTail( this.node1 );
        Node.print_toFromTail( this.node2 );
        Node.print_toFromTail( this.node3 );
        Node.print_toFromTail( this.node4 );
    }

    @Test
    void strings_towardsFromHead() {
        //Make the strings
        String[] node0s = this.node0.strings_toFromHead();
        String[] node1s = this.node1.strings_toFromHead();
        String[] node2s = this.node2.strings_toFromHead();
        String[] node3s = this.node3.strings_toFromHead();
        String[] node4s = this.node4.strings_toFromHead();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromHead( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = this.node0.strings_toFromHead();
        node1s = this.node1.strings_toFromHead();
        node2s = this.node2.strings_toFromHead();
        node3s = this.node3.strings_toFromHead();
        node4s = this.node4.strings_toFromHead();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromHead( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void strings_towardsFromTail() {
        //Make the strings
        String[] node0s = this.node0.strings_toFromTail();
        String[] node1s = this.node1.strings_toFromTail();
        String[] node2s = this.node2.strings_toFromTail();
        String[] node3s = this.node3.strings_toFromTail();
        String[] node4s = this.node4.strings_toFromTail();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromTail( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = this.node0.strings_toFromTail();
        node1s = this.node1.strings_toFromTail();
        node2s = this.node2.strings_toFromTail();
        node3s = this.node3.strings_toFromTail();
        node4s = this.node4.strings_toFromTail();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromTail( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void testStrings_towardsFromHead() {
        //Make the strings
        String[] node0s = Node.strings_toFromHead( this.node0 );
        String[] node1s = Node.strings_toFromHead( this.node1 );
        String[] node2s = Node.strings_toFromHead( this.node2 );
        String[] node3s = Node.strings_toFromHead( this.node3 );
        String[] node4s = Node.strings_toFromHead( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromHead()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = Node.strings_toFromHead( this.node0 );
        node1s = Node.strings_toFromHead( this.node1 );
        node2s = Node.strings_toFromHead( this.node2 );
        node3s = Node.strings_toFromHead( this.node3 );
        node4s = Node.strings_toFromHead( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromHead()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void testStrings_towardsFromTail() {
        //Make the strings
        String[] node0s = Node.strings_toFromTail( this.node0 );
        String[] node1s = Node.strings_toFromTail( this.node1 );
        String[] node2s = Node.strings_toFromTail( this.node2 );
        String[] node3s = Node.strings_toFromTail( this.node3 );
        String[] node4s = Node.strings_toFromTail( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromTail()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = Node.strings_toFromTail( this.node0 );
        node1s = Node.strings_toFromTail( this.node1 );
        node2s = Node.strings_toFromTail( this.node2 );
        node3s = Node.strings_toFromTail( this.node3 );
        node4s = Node.strings_toFromTail( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromTail()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    //Fuck the stringbuilder test


    @Test
    void findHead() {
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node0, this.node1.findHead() );
        assertEquals( this.node0, this.node2.findHead() );
        assertEquals( this.node0, this.node3.findHead() );
        assertEquals( this.node0, this.node4.findHead() );

        //Repeat
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node0, this.node1.findHead() );
        assertEquals( this.node0, this.node2.findHead() );
        assertEquals( this.node0, this.node3.findHead() );
        assertEquals( this.node0, this.node4.findHead() );
    }

    @Test
    void findTail() {
        assertEquals( this.node4, this.node0.findTail() );
        assertEquals( this.node4, this.node1.findTail() );
        assertEquals( this.node4, this.node2.findTail() );
        assertEquals( this.node4, this.node3.findTail() );
        assertEquals( this.node4, this.node4.findTail() );

        //Repeat
        assertEquals( this.node4, this.node0.findTail() );
        assertEquals( this.node4, this.node1.findTail() );
        assertEquals( this.node4, this.node2.findTail() );
        assertEquals( this.node4, this.node3.findTail() );
        assertEquals( this.node4, this.node4.findTail() );
    }

    @Test
    void testFindHead() {
        assertEquals( this.node0, Node.findHead( this.node0 ) );
        assertEquals( this.node0, Node.findHead( this.node1 ) );
        assertEquals( this.node0, Node.findHead( this.node2 ) );
        assertEquals( this.node0, Node.findHead( this.node3 ) );
        assertEquals( this.node0, Node.findHead( this.node4 ) );

        //Repeat
        assertEquals( this.node0, Node.findHead( this.node0 ) );
        assertEquals( this.node0, Node.findHead( this.node1 ) );
        assertEquals( this.node0, Node.findHead( this.node2 ) );
        assertEquals( this.node0, Node.findHead( this.node3 ) );
        assertEquals( this.node0, Node.findHead( this.node4 ) );
    }

    @Test
    void testFindTail() {
        assertEquals( this.node4, Node.findTail( this.node0 ) );
        assertEquals( this.node4, Node.findTail( this.node1 ) );
        assertEquals( this.node4, Node.findTail( this.node2 ) );
        assertEquals( this.node4, Node.findTail( this.node3 ) );
        assertEquals( this.node4, Node.findTail( this.node4 ) );

        //Repeat
        assertEquals( this.node4, Node.findTail( this.node0 ) );
        assertEquals( this.node4, Node.findTail( this.node1 ) );
        assertEquals( this.node4, Node.findTail( this.node2 ) );
        assertEquals( this.node4, Node.findTail( this.node3 ) );
        assertEquals( this.node4, Node.findTail( this.node4 ) );
    }

    @Test
    void find_fromTowards_head() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromHead( String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromHead( String.valueOf( i ) ).data );
        }
    }

    @Test
    void find_fromTowards_tail() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromTail( String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromTail( String.valueOf( i ) ).data );
        }
    }

    @Test
    void testFind_fromTowards_head() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node4, String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node4, String.valueOf( i ) ).data );
        }
    }

    @Test
    void testFind_fromTowards_tail() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node4, String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node4, String.valueOf( i ) ).data );
        }
    }

    @Test
    void findAndRemove_fromTowards_head() {
        assertNull( this.node0.findAndRemove_toFromHead( null ) );
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node4, this.node0.findTail() );

        assertEquals( this.node1, this.node0.next );
        assertNull( this.node0.previous );

        assertNotNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertEquals( "0", this.node2.findAndRemove_toFromHead( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromHead( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromHead( "0" ).data );

        assertNull( this.node0.previous );
        assertNull( this.node0.next );

        assertNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertNull( this.node1.find_toFromHead( "0" ) );
        assertNull( this.node2.find_toFromHead( "0" ) );
        assertNull( this.node3.find_toFromHead( "0" ) );
        assertNull( this.node4.find_toFromHead( "0" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node0.find_toFromHead( String.valueOf( i + 1 ) ) );
        }

        //Repeat with Tail
        assertEquals( this.node3, this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNotNull( this.node3.next );

        assertEquals( "4", this.node1.findAndRemove_toFromHead( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromHead( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromHead( "4" ).data );

        assertNull( this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.find_toFromHead( "4" ) );
        assertNull( this.node1.find_toFromHead( "4" ) );
        assertNull( this.node2.find_toFromHead( "4" ) );
        assertNull( this.node3.find_toFromHead( "4" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node4.find_toFromHead( String.valueOf( i - 1 ) ) );
        }

        //Repeat with Middle
        assertEquals( this.node1, this.node2.previous );
        assertEquals( this.node3, this.node2.next );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertEquals( this.node2, this.node1.next );
        assertEquals( this.node2, this.node3.previous );

        assertEquals( "2", this.node3.findAndRemove_toFromHead( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromHead( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromHead( "2" ).data );

        assertNull( this.node2.previous );
        assertNull( this.node2.next );

        assertEquals( this.node3, this.node1.next );
        assertEquals( this.node1, this.node3.previous );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.find_toFromHead( "2" ) );
        assertNull( this.node1.find_toFromHead( "2" ) );

        assertNull( this.node3.find_toFromHead( "2" ) );
        assertNull( this.node4.find_toFromHead( "2" ) );

        assertNull( this.node2.find_toFromHead( String.valueOf( 0 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 1 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 3 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 4 ) ) );
    }

    @Test
    void findAndRemove_fromTowards_tail() {
        assertNull( this.node0.findAndRemove_toFromTail( null ) );
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node4, this.node0.findTail() );

        assertEquals( this.node1, this.node0.next );
        assertNull( this.node0.previous );

        assertNotNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertEquals( "0", this.node2.findAndRemove_toFromTail( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromTail( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromTail( "0" ).data );

        assertNull( this.node0.previous );
        assertNull( this.node0.next );

        assertNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertNull( this.node1.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node2.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node3.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node4.findAndRemove_toFromTail( "0" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node0.findAndRemove_toFromTail( String.valueOf( i + 1 ) ) );
        }

        //Repeat with Tail
        assertEquals( this.node3, this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNotNull( this.node3.next );

        assertEquals( "4", this.node1.findAndRemove_toFromTail( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromTail( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromTail( "4" ).data );

        assertNull( this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node1.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node2.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node3.findAndRemove_toFromTail( "4" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node4.findAndRemove_toFromTail( String.valueOf( i - 1 ) ) );
        }

        //Repeat with Middle
        assertEquals( this.node1, this.node2.previous );
        assertEquals( this.node3, this.node2.next );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertEquals( this.node2, this.node1.next );
        assertEquals( this.node2, this.node3.previous );

        assertEquals( "2", this.node3.findAndRemove_toFromTail( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromTail( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromTail( "2" ).data );

        assertNull( this.node2.previous );
        assertNull( this.node2.next );

        assertEquals( this.node3, this.node1.next );
        assertEquals( this.node1, this.node3.previous );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.findAndRemove_toFromTail( "2" ) );
        assertNull( this.node1.findAndRemove_toFromTail( "2" ) );

        assertNull( this.node3.findAndRemove_toFromTail( "2" ) );
        assertNull( this.node4.findAndRemove_toFromTail( "2" ) );

        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 0 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 1 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 3 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 4 ) ) );
    }

    @Test
    void insertNode_towardsHead() {
        Node node5 = new Node( "5" );
        Node node6 = new Node( "6" );

        System.out.println( "insert towards head" );
        this.node2.print_toFromHead();
        this.node2.insert_towardsHead( node5 );
        this.node2.print_toFromHead();
        this.node2.insert_towardsHead( node6 );
        this.node2.print_toFromHead();

        assertEquals( node6.data, this.node2.previous.data );
        assertEquals( node5.data, this.node2.previous.previous.data );

        assertEquals( this.node2.data, node6.next.data );
        assertEquals( this.node2.data, node5.next.next.data );

        node5.insert_towardsHead( this.node2 );
        node6.print_toFromHead();
        node5.insert_towardsHead( this.node2 );
        node6.print_toFromHead();
        node5.insert_towardsHead( this.node2 );
        node6.print_toFromHead();

        assertEquals( this.node2.data, node5.previous.data );
        assertEquals( node5.data, this.node2.next.data );


        String[] node2s = this.node2.strings_toFromHead();
        String[] node6s = node6.strings_toFromHead();

        for ( int i = 0; i < node6s.length; i++ ) {
            assertEquals( node2s[ i ], node6s[ i ] );
        }

        node6.print_toFromHead();
        assertEquals( 7, node5.strings_toFromHead().length );
        node6.remove();
        node5.print_toFromHead();
        assertEquals( 6, node5.strings_toFromHead().length );
        assertEquals( 1, node6.strings_toFromHead().length );
        node6.print_toFromHead();
        System.out.println();

    }

    @Test
    void insertNode_towardsTail() {
        Node node5 = new Node( "5" );
        Node node6 = new Node( "6" );

        System.out.println( "insert towards tail" );
        this.node2.print_toFromHead();

        this.node2.insert_towardsTail( node5 );
        this.node2.print_toFromHead();
        this.node2.insert_towardsTail( node6 );
        this.node2.print_toFromHead();

        assertEquals( node6.data, this.node2.next.data );
        assertEquals( node5.data, this.node2.next.next.data );

        node5.insert_towardsTail( this.node2 );
        this.node2.print_toFromHead();
        node5.insert_towardsTail( this.node2 );
        this.node2.print_toFromHead();

        assertEquals( this.node2.data, node5.next.data );
        assertEquals( this.node2.data, node6.next.next.data );

        String[] node2s = this.node2.strings_toFromTail();
        String[] node6s = node6.strings_toFromTail();

        for ( int i = 0; i < node6s.length; i++ ) {
            assertEquals( node2s[ i ], node6s[ i ] );
        }

        node6.print_toFromHead();
        assertEquals( 7, node5.strings_toFromHead().length );
        node6.remove();
        node5.print_toFromHead();
        assertEquals( 6, node5.strings_toFromHead().length );
        assertEquals( 1, node6.strings_toFromHead().length );
        node6.print_toFromHead();
        System.out.println();


    }

    @Test
    void insertNode_towardsHead_INSANE() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE Insertion Test, HEAD------------" );
        this.node0.print_toFromHead();
        System.out.println();

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeNs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeNs.get( j );

                nodeI.insert_towardsHead( nodeJ );
                System.out.println( "i = " + i + " , j = " + j );
                nodeI.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( nodeJ.getData() ) ) {
                    assertEquals( nodeI.getPrevious().getData(), nodeJ.getData() );
                    assertEquals( nodeI.getData(), nodeJ.getNext().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( nodeJ.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeJ.getData() ) );

                assertNotNull( nodeJ.find_toFromTail( nodeJ.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeJ.getData() ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );


                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() );

            }

        }
    }

    @Test
    void insertNode_towardsTail_INSANE() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE Insertion Test, TAIL------------" );
        this.node0.print_toFromHead();
        System.out.println();

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeNs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeNs.get( j );

                nodeI.insert_towardsTail( nodeJ );
                System.out.println( "i = " + i + " , j = " + j );
                nodeI.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( nodeJ.getData() ) ) {
                    assertEquals( nodeI.getNext().getData(), nodeJ.getData() );
                    assertEquals( nodeI.getData(), nodeJ.getPrevious().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( nodeJ.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeJ.getData() ) );

                assertNotNull( nodeJ.find_toFromTail( nodeJ.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeJ.getData() ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );


                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() );


            }

        }
    }

    @Test
    void insertNode_betweenLists_InsaneAfterHead() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE BETWEEN LISTS FIND AND INSERT Test, AFTER (Head)------------" );
        this.node0.print_toFromHead();
        System.out.println();

        Node nodeL = NodeLs.get( 0 );
        Node nodeF = new Node( "F" );
        nodeL.findTail().insert_towardsTail( nodeF );

        int sizeIncrease = 0;

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeLs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeLs.get( j );

                String dataJ = this.NodeLs.get( j ).getData();

                if ( i == 0 ) {
                    nodeI.findAndInsertAfter_toFromHead( nodeF, dataJ );
                } else {
                    nodeI.findAndInsertAfter_toFromHead( dataJ );
                }
                System.out.println( "i = " + i + " , j = " + this.NodeLs.get( j ).getData() );
                this.node0.print_toFromHead();
                nodeF.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( dataJ ) ) {
                    assertEquals( dataJ, nodeI.getNext().getData() );
                    assertEquals( nodeI.getData(), nodeJ.getPrevious().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( dataJ ) );
                assertNotNull( nodeI.find_toFromHead( dataJ ) );

                assertNotNull( nodeJ.find_toFromTail( dataJ ) );
                assertNotNull( nodeJ.find_toFromHead( dataJ ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );

                if ( i == 0 ) {
                    sizeIncrease++;
                }
                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );

                assertEquals( nodeF.strings_toFromHead().length, this.NodeLs.size() + 1 - sizeIncrease );
                assertEquals( nodeF.strings_toFromTail().length, this.NodeLs.size() + 1 - sizeIncrease );


            }

        }
    }

    @Test
    void insertNode_betweenLists_InsaneBeforeHead() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE BETWEEN LISTS FIND AND INSERT Test, BEFORE (Head)------------" );
        this.node0.print_toFromHead();
        System.out.println();

        Node nodeL = NodeLs.get( 0 );
        Node nodeF = new Node( "F" );
        nodeL.findTail().insert_towardsTail( nodeF );

        int sizeIncrease = 0;

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeLs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeLs.get( j );

                String dataJ = this.NodeLs.get( j ).getData();

                if ( i == 0 ) {
                    nodeI.findAndInsertBefore_toFromHead( nodeF, dataJ );
                } else {
                    nodeI.findAndInsertBefore_toFromHead( dataJ );
                }
                System.out.println( "i = " + i + " , j = " + this.NodeLs.get( j ).getData() );
                this.node0.print_toFromHead();
                nodeF.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( dataJ ) ) {
                    assertEquals( dataJ, nodeI.getPrevious().getData() );
                    assertEquals( nodeI.getData(), nodeJ.getNext().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( dataJ ) );
                assertNotNull( nodeI.find_toFromHead( dataJ ) );

                assertNotNull( nodeJ.find_toFromTail( dataJ ) );
                assertNotNull( nodeJ.find_toFromHead( dataJ ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );

                if ( i == 0 ) {
                    sizeIncrease++;
                }
                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );

                assertEquals( nodeF.strings_toFromHead().length, this.NodeLs.size() + 1 - sizeIncrease );
                assertEquals( nodeF.strings_toFromTail().length, this.NodeLs.size() + 1 - sizeIncrease );


            }

        }
    }


    @Test
    void insertNode_betweenLists_InsaneAfterTail() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE BETWEEN LISTS FIND AND INSERT Test, AFTER (Tail)------------" );
        this.node0.print_toFromHead();
        System.out.println();

        Node nodeL = NodeLs.get( 0 );
        Node nodeF = new Node( "F" );
        nodeL.findTail().insert_towardsTail( nodeF );

        int sizeIncrease = 0;

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeLs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeLs.get( j );

                String dataJ = this.NodeLs.get( j ).getData();

                if ( i == 0 ) {
                    nodeI.findAndInsertAfter_toFromTail( nodeF, dataJ );
                } else {
                    nodeI.findAndInsertAfter_toFromTail( dataJ );
                }
                System.out.println( "i = " + i + " , j = " + this.NodeLs.get( j ).getData() );
                this.node0.print_toFromHead();
                nodeF.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( dataJ ) ) {
                    assertEquals( dataJ, nodeI.getNext().getData() );
                    assertEquals( nodeI.getData(), nodeJ.getPrevious().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( dataJ ) );
                assertNotNull( nodeI.find_toFromHead( dataJ ) );

                assertNotNull( nodeJ.find_toFromTail( dataJ ) );
                assertNotNull( nodeJ.find_toFromHead( dataJ ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );

                if ( i == 0 ) {
                    sizeIncrease++;
                }
                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );

                assertEquals( nodeF.strings_toFromHead().length, this.NodeLs.size() + 1 - sizeIncrease );
                assertEquals( nodeF.strings_toFromTail().length, this.NodeLs.size() + 1 - sizeIncrease );


            }

        }
    }

    @Test
    void insertNode_betweenLists_InsaneBeforeTail() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE BETWEEN LISTS FIND AND INSERT Test, BEFORE (Tail)------------" );
        this.node0.print_toFromHead();
        System.out.println();

        Node nodeL = NodeLs.get( 0 );
        Node nodeF = new Node( "F" );
        nodeL.findTail().insert_towardsTail( nodeF );

        int sizeIncrease = 0;

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeLs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeJ = this.NodeLs.get( j );

                String dataJ = this.NodeLs.get( j ).getData();

                if ( i == 0 ) {
                    nodeI.findAndInsertBefore_toFromTail( nodeF, dataJ );
                } else {
                    nodeI.findAndInsertBefore_toFromTail( dataJ );
                }
                System.out.println( "i = " + i + " , j = " + this.NodeLs.get( j ).getData() );
                this.node0.print_toFromHead();
                nodeF.print_toFromHead();
                System.out.println();

                if ( !nodeI.getData().equals( dataJ ) ) {
                    assertEquals( dataJ, nodeI.getPrevious().getData() );
                    assertEquals( nodeI.getData(), nodeJ.getNext().getData() );
                }

                assertNotNull( nodeI.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromHead( nodeI.getData() ) );
                assertNotNull( nodeI.find_toFromTail( dataJ ) );
                assertNotNull( nodeI.find_toFromHead( dataJ ) );

                assertNotNull( nodeJ.find_toFromTail( dataJ ) );
                assertNotNull( nodeJ.find_toFromHead( dataJ ) );
                assertNotNull( nodeJ.find_toFromTail( nodeI.getData() ) );
                assertNotNull( nodeJ.find_toFromHead( nodeI.getData() ) );

                if ( i == 0 ) {
                    sizeIncrease++;
                }
                assertEquals( nodeI.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeI.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromHead().length, this.NodeNs.size() + sizeIncrease );
                assertEquals( nodeJ.strings_toFromTail().length, this.NodeNs.size() + sizeIncrease );

                assertEquals( nodeF.strings_toFromHead().length, this.NodeLs.size() + 1 - sizeIncrease );
                assertEquals( nodeF.strings_toFromTail().length, this.NodeLs.size() + 1 - sizeIncrease );


            }

        }
    }

    @Test
    void replace_INSANE() {
        System.out.println();
        System.out.println( "--------------------Start of the INSANE Replace Test------------" );
        this.node0.print_toFromHead();
        System.out.println();

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            for ( int j = 0; j < this.NodeNs.size(); j++ ) {
                Node nodeI = this.NodeNs.get( i );
                Node nodeIOld = new Node( nodeI.getData() );
                nodeIOld.next = nodeI.getNext();
                nodeIOld.previous = nodeI.getPrevious();

                Node nodeJ = this.NodeNs.get( j );

                nodeI.replace( nodeJ );
                System.out.println( "i = " + i + " , j = " + j );
                this.node4.print_toFromHead();
                System.out.println();

                if ( !this.NodeNs.get( i ).getData().equals( this.NodeNs.get( j ).getData() ) ) {
                    assertNull( nodeI.getNext() );
                    assertNull( nodeI.getPrevious() );

                    if ( nodeIOld.getNext() != nodeJ ) {
                        assertEquals( nodeIOld.getNext(), nodeJ.getNext() );
                        if ( nodeIOld.getNext() != null ) {
                            assertEquals( nodeIOld.getNext().getPrevious(), nodeJ.getNext().getPrevious() );
                        }
                    }
                    if ( nodeIOld.getPrevious() != nodeJ ) {
                        assertEquals( nodeIOld.getPrevious(), nodeJ.getPrevious() );
                        if ( nodeIOld.getPrevious() != null ) {
                            assertEquals( nodeIOld.getPrevious().getNext(), nodeJ.getPrevious().getNext() );
                        }
                    }


                }


            }

        }
    }

    @Test
    void replace() {
        System.out.println();
        System.out.println( "--------------------Start of the Replace Test------------" );
        this.node0.print_toFromHead();
        System.out.println();

        for ( int i = 0; i < this.NodeNs.size(); i++ ) {
            int j = this.NodeLs.size() - 1 - i;
            Node nodeI = this.NodeNs.get( i );
            Node nodeIOld = new Node( nodeI.getData() );
            nodeIOld.next = nodeI.getNext();
            nodeIOld.previous = nodeI.getPrevious();

            Node nodeJ = this.NodeLs.get( j );

            nodeI.replace( nodeJ );
            System.out.println( "i = " + i + " , j = " + this.NodeLs.get( j ).getData() );
            nodeJ.print_toFromHead();
            System.out.println();

            if ( !this.NodeNs.get( i ).getData().equals( this.NodeLs.get( j ).getData() ) ) {
                assertNull( nodeI.getNext() );
                assertNull( nodeI.getPrevious() );

                if ( nodeIOld.getNext() != nodeJ ) {
                    assertEquals( nodeIOld.getNext(), nodeJ.getNext() );
                    if ( nodeIOld.getNext() != null ) {
                        assertEquals( nodeIOld.getNext().getPrevious(), nodeJ.getNext().getPrevious() );
                    }
                }
                if ( nodeIOld.getPrevious() != nodeJ ) {
                    assertEquals( nodeIOld.getPrevious(), nodeJ.getPrevious() );
                    if ( nodeIOld.getPrevious() != null ) {
                        assertEquals( nodeIOld.getPrevious().getNext(), nodeJ.getPrevious().getNext() );
                    }
                }


            }


        }
    }


    //----------------------------------------THERE IS A LOT OF STUFF I HAVE YET TO TEST, FUCK IT---------------------------------------


    @Test
    void testStringsToNetwork() {
        System.out.println();
        System.out.println( "--------------------Start of the Strings to Network Test------------" );

        Node networkHeadTal = Node.stringsToNetwork( this.stringsTal );
        networkHeadTal.print_toFromHead();
        assertEquals( this.stringsTal[ 0 ], networkHeadTal.getData() );
        assertEquals( this.stringsTal[ 1 ], networkHeadTal.getNext().getData() );

        String[] strings = networkHeadTal.strings_toFromHead();
        assertEquals( this.stringsTal.length, strings.length );
        for ( int i = 0; i < strings.length; i++ ) {
            assertEquals( this.stringsTal[ i ], strings[ i ] );
        }

        //Null test
        String[] stringsTalNull = null;
        networkHeadTal = Node.stringsToNetwork( stringsTalNull);
        assertNull( networkHeadTal );

        //Filled Null test
        String[] stringsTalFilledWithNull = new String[]{
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
        };
        networkHeadTal = Node.stringsToNetwork( stringsTalFilledWithNull);
        assertNull( networkHeadTal );

        //Null test inside the array
        System.out.println();
        System.out.println( "The Null test" );
        System.out.println();

        String[] stringsTalPartiallyFilledWithNull = new String[]{
                null,
                "0",
                null,
                null,
                null,
                "1",
                "2",
                "3",
                null,
                "4",
                null,
                null,
                null,
        };
        networkHeadTal = Node.stringsToNetwork( stringsTalPartiallyFilledWithNull );
        networkHeadTal.print_toFromHead();
        assertEquals( this.stringsTal[ 0 ], networkHeadTal.getData() );
        assertEquals( this.stringsTal[ 1 ], networkHeadTal.getNext().getData() );

        strings = networkHeadTal.strings_toFromHead();
        assertEquals( this.stringsTal.length, strings.length );
        for ( int i = 0; i < strings.length; i++ ) {
            assertEquals( this.stringsTal[ i ], strings[ i ] );
        }
    }

}