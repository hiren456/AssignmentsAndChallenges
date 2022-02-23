import java.util.Random;

public class A3PatelHirenkumar {
    public static void main(String[] args)
    {
        System.out.println("COMP 2140 Assignment 3 Fall 2018");
        startNewGame(); //Start of a new game
        System.out.println("\n\nProgram ends normally");
    }
    private static void startNewGame()
    {
        ArrayImplementedQueue queue1 = new ArrayImplementedQueue(); //Player one
        ArrayImplementedQueue queue2 = new ArrayImplementedQueue(); //Player two
        startPlaying(queue1, queue2);//Game starts
    }
    private static final int MAX_SIZE = 52; //Number of cards(one deck)

    static class ArrayImplementedQueue
    {
        private int[] nums = new int[MAX_SIZE];
        private int front; //variable that gives the index of front element in the array
        private int end;   //variable that gives the index of last element in the array

        public ArrayImplementedQueue() {
            front = -1;
            end = -1; // if both front and end==-1 then the array is empty.
        }

        public boolean isFull()
        {
            return ((end + 1) % MAX_SIZE) == front; //checks if array is full
        }

        public boolean isEmpty()
        {
            return (front == -1) && (end == -1);//checks if array is empty
        }

        public void enqueue(int x) {
            if (isFull()) {
                //do nothing if array is full
                System.out.println();
            } else if (isEmpty()) {
                //if empty both front and end will be set to 0(the first index in the array)
                front = end = 0;
            } else {
                //update end to the next position
                end = (end + 1) % MAX_SIZE;
            }
            //set element at end index to x
            nums[end] = x;
        }

        public int front() {
            if (isEmpty())
            {// if empty then we don't do anything since we have no element in the array
                System.out.println();
                return front;
            } else
                {
                //return the first element of the array
                return nums[front];
            }
        }

        public int dequeue() {
            int result = -1;
            if (isEmpty())
            {
                //we don't have any element to dequeue
                System.out.println();
                return result;
            }
            else if (front == end)
            {  //if we only have one element in the list, then empty the list
                result = nums[front];
                front=end=-1;
            }
            else
            {
                //delete the element at index front
                result = nums[front];
                front=(front+1)%MAX_SIZE;}

            return result;//returns what's deleted
        }
    }

    static class ArrayImplementedStack {
        private int[] nums = new int[MAX_SIZE];
        private int top; //gives the index of the top-most element in the array

        public ArrayImplementedStack() {
            top = -1;
        }

        public boolean isFull() {
            return top == MAX_SIZE - 1;
        }//returns true if stack is full

        public boolean isEmpty() {
            return top == -1;
        }//returns true is stack is empty

        public void push(int x) {
            if (top == nums.length - 1)
                System.out.println();
            //if stack is full do nothing
            else {
                top = top + 1;//update top to the next index in the array
                nums[top] = x;//set x as an element at index top
            }
        }

        public int pop() {

            if (isEmpty()) {
                return top;//if stack is empty return -1
            } else {
                top = top - 1;//decrement top to delete the element
                return nums[top + 1];//return element that was at top+1
            }
        }

        public int top() {
            if (!isEmpty()) {
                return nums[top];//returns the element at the top of the stack
            } else {
                return top;//if stack is empty return -1
            }
        }
    }
    private static void swap(int[]nums,int i,int j)
    { //swapping two values in an array
        int temp=nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }//end swap
    public static void fillRandomArray(int[]nums,int MAX_SIZE)
    { //randomly fills array and performs n swaps(shuffling) within the array
        Random numberGenerator=new Random();
        for(int i=0; i<nums.length; i++)
        {//fill array with values from 0 to 51
            {
                nums[i] = i;
            }
        }//array is filled

        int swaps=MAX_SIZE;
        while(swaps>0)
        {
            swap(nums,numberGenerator.nextInt(nums.length),numberGenerator.nextInt(nums.length));
            swaps--;
        }//swaps are done to make the array random(shuffling)
    }
    public static void randomFillDeckAndDistribute(ArrayImplementedQueue player1,ArrayImplementedQueue player2)
    {
        int[] deck= new int[MAX_SIZE]; //array where the cards are to be stored
        fillRandomArray(deck,MAX_SIZE);//array is filled with cards and shuffled
        for(int i=0; i<MAX_SIZE; i++)
        {//cards are distributed to both players equally
            if(i<MAX_SIZE/2)
            {
                player1.enqueue(deck[i]);
            }
            else
                {
                    player2.enqueue(deck[i]);
                }
        }
    }
    public static void emptyStacks(ArrayImplementedStack stackPlayer1, ArrayImplementedStack stackPlayer2,ArrayImplementedQueue player)
    {//player who wins, gets all cards so both of the stacks are emptied into the players queue

        while (!stackPlayer1.isEmpty()||!stackPlayer2.isEmpty())
        {
            if(!stackPlayer1.isEmpty())
            {
                player.enqueue(stackPlayer1.pop());
            }
            else
                {
                player.enqueue(stackPlayer2.pop());
            }
        }

    }
    public static String suitCalculator(int c)
    {
        if(c/13==0)
        {//spades suit
            return "\u2660";
        }
        else if(c/13==1)
        {//diamonds suit
        return "\u2666";
        }
        else if(c/13==2)
        {//hearts suit
        return "\u2665";
        }
        else
        {//clubs suit
        return "\u2663";
        }
    }
    public static String cardRank(int c)
    {
        String cardRank;
        if(c>1&&c<11)
        { //cards with values 2 to 10 are returned with the same rank
            cardRank=Integer.toString(c);
        }
        else if(c==1)
        { //cards with value 1 are returned with rank A
            cardRank="A";
        }
        else if(c==11)
        { //cards with value 11 are returned with rank J
            cardRank="J";
        }
        else if(c==12)
        { //cards with value 12 are returned with rank Q
            cardRank="Q";
        }
        else
            { //cards with value 13 are returned with rank K
                cardRank="K";
            }
            return cardRank;
    }

    public static void startPlaying(ArrayImplementedQueue player1,ArrayImplementedQueue player2)
    {//Game starts
        System.out.println("Playing the War card game...");
        randomFillDeckAndDistribute(player1,player2);//both players get cards
        ArrayImplementedStack stackPlayer1=new ArrayImplementedStack();//stack for player1
        ArrayImplementedStack stackPlayer2=new ArrayImplementedStack();//stack for player2
        while (!player1.isEmpty()&&!player2.isEmpty())
        {//loop runs till either of the players' run out of cards
            stackPlayer1.push(player1.dequeue());//player1 reveals a card
            System.out.print("Player 1: "+ cardRank((1+(stackPlayer1.top()%13)))+suitCalculator(stackPlayer1.top())+"  ");
            stackPlayer2.push(player2.dequeue());//player2 reveals a card
            System.out.print("\tPlayer 2:  "+ cardRank((1+(stackPlayer2.top()%13)))+suitCalculator(stackPlayer2.top()));
            if((1+(stackPlayer1.top()%13))>(1+(stackPlayer2.top()%13)))
            {//if player1 wins, he/she gets all the cards in both stacks
                System.out.println("\tPlayer 1 gets both cards");
                emptyStacks(stackPlayer1,stackPlayer2,player1);
            }
            else if((1+(stackPlayer2.top()%13))>(1+(stackPlayer1.top()%13)))
            {//if player2 wins, he/she gets all the cards in both stacks
                System.out.println("\tPlayer 2 gets both cards");
                emptyStacks(stackPlayer1,stackPlayer2,player2);
            }
            else {
                //if player1 and player2 cards are equal then they go into a WAR
                    System.out.println("\n  ** It is WAR!");
                    System.out.println("Player 1 ante:");
                    if (!player1.isEmpty()) {
                        stackPlayer1.push(player1.dequeue());
                        System.out.println(cardRank((1 + (stackPlayer1.top() % 13))) + suitCalculator(stackPlayer1.top()));
                    }//check for player running out of cards
                    if (!player1.isEmpty()) {
                        stackPlayer1.push(player1.dequeue());
                        System.out.println(cardRank((1+(stackPlayer1.top() % 13))) + suitCalculator(stackPlayer1.top()));
                    }//check for player running out of cards
                    if(!player1.isEmpty())
                    {
                        System.out.println("Player 2 ante:");
                    if (!player2.isEmpty()) {
                        stackPlayer2.push(player2.dequeue());
                        System.out.println(cardRank((1 + (stackPlayer2.top() % 13))) + suitCalculator(stackPlayer2.top()));
                    }//check for player running out of cards
                    if (!player2.isEmpty()) {
                        stackPlayer2.push(player2.dequeue());
                        System.out.println(cardRank((1 + (stackPlayer2.top() % 13))) + suitCalculator(stackPlayer2.top()));
                    }//check for player running out of cards
                    }
                if(!player2.isEmpty()){//check for player running out of cards
                war(player1,player2,stackPlayer1,stackPlayer2);}
            }
        }
        if(player1.isEmpty())
        {
            System.out.println(" ** Player 1 is out of cards");
            System.out.println("\nPlayer 2 won the game!");
        }
        else
            {
                System.out.println(" ** Player 2 is out of cards");
                System.out.println("\nPlayer 1 won the game!");
            }//checks for which player ran out of cards and prints it out
    }
    public static void war(ArrayImplementedQueue player1, ArrayImplementedQueue player2, ArrayImplementedStack stackPlayer1, ArrayImplementedStack stackPlayer2)
    {
        if(!player1.isEmpty()&&!player2.isEmpty()) {
            stackPlayer1.push(player1.dequeue());//player1 reveals a card
            System.out.print("Player 1: " + cardRank((1 + (stackPlayer1.top() % 13))) + suitCalculator(stackPlayer1.top()) + "  ");
            stackPlayer2.push(player2.dequeue());//player2 reveals a card
            System.out.print("\tPlayer 2:  " + cardRank((1 + (stackPlayer2.top() % 13))) + suitCalculator(stackPlayer2.top()));
            if ((1 + (stackPlayer1.top() % 13)) > (1 + (stackPlayer2.top() % 13))) {
                System.out.println("\tPlayer 1 gets both cards");
                System.out.println(" ** Player 1 won this battle");
                emptyStacks(stackPlayer1, stackPlayer2, player1);//if player1 wins, he gets all the cards in both stacks
            } else if ((1 + (stackPlayer1.top() % 13)) < (1 + (stackPlayer2.top() % 13))) {
                System.out.println("\tPlayer 2 gets both cards");
                System.out.println(" ** Player 2 won this battle");
                emptyStacks(stackPlayer1, stackPlayer2, player2);//if player2 wins, he gets all the cards in both stacks
            } else {
                //if player1 and player2 cards are equal, the WAR continues!
                System.out.println("\n  **  WAR continues!");
                if (!player1.isEmpty()) {
                    stackPlayer1.push(player1.dequeue());
                } else {
                    if (!player1.isEmpty()) {
                        stackPlayer1.push(player1.dequeue());
                    }
                }
                if (!player2.isEmpty()) {
                    stackPlayer2.push(player2.dequeue());
                } else {
                    if (!player2.isEmpty()) {
                        stackPlayer2.push(player2.dequeue());
                    }
                }
                if (!player1.isEmpty() && !player2.isEmpty())
                {
                    war(player1, player2, stackPlayer1, stackPlayer2);
                }
            }

        }
    }
}

