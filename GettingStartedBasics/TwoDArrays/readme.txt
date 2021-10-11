Check all 2D questions

//Check Spiral one and Rotation specailly, these concepts are used in DP problems


//For Hacker rank , 2D multiline inputs are taken as :

 Scanner scn = new Scanner(System.in);     

int n =Integer.parseInt( scn.nextLine());
int[][] a = new int[n][n];
for (int i = 0; i < n; i++) {            
    String str = scn.nextLine();
    String[] temp = str.split(" ");
    for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(temp[j]);

    }

}