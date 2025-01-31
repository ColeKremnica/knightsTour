package Code;

public class LinkedGrid {
    static Node start; // Starting node of the grid

    // Constructor to create a size x size grid
    public LinkedGrid(int size) {
        System.out.println("creating board...");
        if (size > 0) {
            start = new Node();
            Node temp = start;
            Node row = start;

            // Creating the first row
            for (int x = 0; x < size - 1; x++) {
                temp.setRight(new Node());
                temp.getRight().setLeft(temp);
                temp = temp.getRight();
            }

            // Creating the remaining rows and linking them
            for (int x = 0; x < size - 1; x++) {
                row.setDown(new Node());
                row.getDown().setUp(row);
                row = row.getDown();
                temp = row;

                for (int y = 0; y < size - 1; y++) {
                    temp.setRight(new Node());
                    temp.getRight().setLeft(temp);
                    temp.getRight().setUp(temp.getUp().getRight());
                    temp.getRight().getUp().setDown(temp.getRight());
                    temp = temp.getRight();
                }
            }

            createPaths(); // Set up additional movement paths
            freedom(); // Calculate movement freedom for each node
        }
    }
    // Establishes paths for knight-like movements (L-shaped moves)
    public void createPaths() {
        Node temp = start;
        Node marker = start;

        while (marker != null) {
            while (temp != null) {
                try { temp.setPath1(temp.getUp().getUp().getLeft()); } catch (Exception e) {}
                try { temp.setPath2(temp.getUp().getUp().getRight()); } catch (Exception e) {}
                try { temp.setPath3(temp.getRight().getRight().getUp()); } catch (Exception e) {}
                try { temp.setPath4(temp.getRight().getRight().getDown()); } catch (Exception e) {}
                try { temp.setPath5(temp.getDown().getDown().getLeft()); } catch (Exception e) {}
                try { temp.setPath6(temp.getDown().getDown().getRight()); } catch (Exception e) {}
                try { temp.setPath7(temp.getLeft().getLeft().getDown()); } catch (Exception e) {}
                try { temp.setPath8(temp.getLeft().getLeft().getUp()); } catch (Exception e) {}
                temp = temp.getRight();
            }
            temp = marker.getDown();
            marker = temp;
        }
    }

    // Calculates the number of available moves (freedom) for a node
    public void findFreedom(Node temp) {
        int freedom = 8;
        if (temp.getPath1() == null || temp.getPath1().getData() != 0) freedom--;
        if (temp.getPath2() == null || temp.getPath2().getData() != 0) freedom--;
        if (temp.getPath3() == null || temp.getPath3().getData() != 0) freedom--;
        if (temp.getPath4() == null || temp.getPath4().getData() != 0) freedom--;
        if (temp.getPath5() == null || temp.getPath5().getData() != 0) freedom--;
        if (temp.getPath6() == null || temp.getPath6().getData() != 0) freedom--;
        if (temp.getPath7() == null || temp.getPath7().getData() != 0) freedom--;
        if (temp.getPath8() == null || temp.getPath8().getData() != 0) freedom--;
        temp.setFreedom(freedom);
    }

    // Reduces the available moves for a node
    public int setsFreedom(Node position) {
        Node temp = position;
        if (temp.getFreedom() >= 1) {
            temp.setFreedom(temp.getFreedom() - 1);
            if (temp.getFreedom() == 1) {
                return 1;
            }
        }
        return 0;
    }

    // Restores a move when backtracking
    public void resetsFreedom(Node temp) {
        if (temp.getFreedom() < 8) {
            temp.setFreedom(temp.getFreedom() + 1);
        }
    }

    // Initializes the freedom values for all nodes
    public void freedom() {
        Node temp = start;
        Node marker = start;
        while (marker != null) {
            while (temp != null) {
                findFreedom(temp);
                temp = temp.getRight();
            }
            temp = marker.getDown();
            marker = temp;
        }
    }

    // Displays the freedom values of the grid
    public void displayFreedom() {
        System.out.println();
        Node temp = start;
        Node marker = start;

        while (marker != null) {
            while (temp != null) {
                System.out.print(temp.getFreedom() + "  ");
                temp = temp.getRight();
            }
            System.out.println();
            temp = marker.getDown();
            marker = temp;
        }
    }

    // Displays the grid with node values
    public void display() {
        System.out.println();
        Node temp = start;
        Node marker = start;

        while (marker != null) {
            while (temp != null) {
                if (temp.getData() < 10)
                    System.out.print(temp.getData() + "  ");
                else
                    System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
            System.out.println();
            temp = marker.getDown();
            marker = temp;
        }
    }

    // Initiates the knight's tour algorithm
    public void startTour() {
        int solutionsFound = tour(start, 0, 0, 0);
        System.out.println();
        System.out.println(solutionsFound + " Solutions found");
    }

    // Backtracking algorithm for the knight's tour
    public int tour(Node position, int numb, int count, int freedom) {
        numb++;
        position.setData(numb);
        resetsFreedom(position);

        // If all squares are visited, print the solution
        if (numb == 25) {
            display();
            count++;
            position.setData(0);
            return count;
        }

        // If the position has too few options left, backtrack
        if (freedom > 3) {
            position.setData(0);
            return count;
        }

        // Attempt all possible knight moves
        if (position.getPath1() != null && position.getPath1().getData() == 0) {
            freedom += setsFreedom(position.getPath1());
            count = tour(position.getPath1(), numb, count, freedom);
        }
        if (position.getPath2() != null && position.getPath2().getData() == 0) {
            freedom += setsFreedom(position.getPath2());
            count = tour(position.getPath2(), numb, count, freedom);
        }
        if (position.getPath3() != null && position.getPath3().getData() == 0) {
            freedom += setsFreedom(position.getPath3());
            count = tour(position.getPath3(), numb, count, freedom);
        }
        if (position.getPath4() != null && position.getPath4().getData() == 0) {
            freedom += setsFreedom(position.getPath4());
            count = tour(position.getPath4(), numb, count, freedom);
        }
        if (position.getPath5() != null && position.getPath5().getData() == 0) {
            freedom += setsFreedom(position.getPath5());
            count = tour(position.getPath5(), numb, count, freedom);
        }
        if (position.getPath6() != null && position.getPath6().getData() == 0) {
            freedom += setsFreedom(position.getPath6());
            count = tour(position.getPath6(), numb, count, freedom);
        }
        if (position.getPath7() != null && position.getPath7().getData() == 0) {
            freedom += setsFreedom(position.getPath7());
            count = tour(position.getPath7(), numb, count, freedom);
        }
        if (position.getPath8() != null && position.getPath8().getData() == 0) {
            freedom += setsFreedom(position.getPath8());
            count = tour(position.getPath8(), numb, count, freedom);
        }

        // Backtrack
        position.setData(0);
        return count;
    }
}
