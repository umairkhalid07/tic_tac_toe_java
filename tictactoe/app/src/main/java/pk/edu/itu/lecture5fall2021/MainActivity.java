package pk.edu.itu.lecture5fall2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    int[][] data;
    ImageButton[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        buttons = new ImageButton[5][5];
        data = new int[5][5];

        buttons[0][0] = findViewById(R.id.img1);
        buttons[0][1] = findViewById(R.id.img2);
        buttons[0][2] = findViewById(R.id.img3);
        buttons[0][3] = findViewById(R.id.img4);
        buttons[0][4] = findViewById(R.id.img5);
        buttons[1][0] = findViewById(R.id.img6);
        buttons[1][1] = findViewById(R.id.img7);
        buttons[1][2] = findViewById(R.id.img8);
        buttons[1][3] = findViewById(R.id.img9);
        buttons[1][4] = findViewById(R.id.img10);
        buttons[2][0] = findViewById(R.id.img11);
        buttons[2][1] = findViewById(R.id.img12);
        buttons[2][2] = findViewById(R.id.img13);
        buttons[2][3] = findViewById(R.id.img14);
        buttons[2][4] = findViewById(R.id.img15);
        buttons[3][0] = findViewById(R.id.img16);
        buttons[3][1] = findViewById(R.id.img17);
        buttons[3][2] = findViewById(R.id.img18);
        buttons[3][3] = findViewById(R.id.img19);
        buttons[3][4] = findViewById(R.id.img20);
        buttons[4][0] = findViewById(R.id.img21);
        buttons[4][1] = findViewById(R.id.img22);
        buttons[4][2] = findViewById(R.id.img23);
        buttons[4][3] = findViewById(R.id.img24);
        buttons[4][4] = findViewById(R.id.img25);

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                final int a = i;
                final int b = j;
                buttons[a][b].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (data[a][b] != 0)
                            return;
                        if (count % 2 == 0) {
                            buttons[a][b].setImageResource(R.drawable.sun);
                            data[a][b] = 1;
                        }
                        else
                        {
                            buttons[a][b].setImageResource(R.drawable.snow);
                            data[a][b] = 2;
                        }
                        String output="";
                        for(int x =0; x<3; x++)
                            for(int y=0; y<3; y++)
                                output+= data[x][y]+",";
                        Log.d("TICTACTOE",output);

                        boolean check;

                        for (int x = 0; x < 5; x++) {
                            check = true;
                            int temp = data[x][0];
                            for (int y = 0; y < 5; y++) {
                                if (data[x][y] != temp || temp == 0) {
                                    check = false;
                                    break;
                                }
                            }

                            if (check == true) {
                                //won game
                                win();
                                return;
                            }
                        }

                        for (int y = 0; y < 5; y++){
                            check = true;
                            int temp = data[0][y];
                            for (int x = 0; x < 5; x++){
                                if (data[x][y] != temp || temp == 0){
                                    check = false;
                                    break;
                                }
                            }
                            if (check == true){
                                //won game
                                win();
                                return;
                            }
                        }

                        check = true;
                        int temp1 = data[0][0];
                        for (int xy = 0; xy < 5; xy++){
                            if (data[xy][xy] != temp1 || temp1 == 0){
                                check = false;
                                break;
                            }
                        }

                        if (check == true){
                            //won game
                            win();
                            return;
                        }

                        check = true;
                        int temp2 = data[0][4];
                        if ((data[1][3] != temp2 || temp2 == 0) || (data[2][2] != temp2 || temp2 == 0) || (data[3][1] != temp2 || temp2 == 0) || (data[4][0] != temp2 || temp2 == 0)){
                            check = false;
                        }

                        if (check == true){
                            //won game
                            win();
                            return;
                        }
                        count++;
                    }
                });
            }
        }
    }

    void win()
    {
        if (count % 2 == 0) {
            Toast.makeText(getApplicationContext(), "Player 1 Sun  wins", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Player 2 Snow wins", Toast.LENGTH_LONG).show();
        }
        resetGame();
    }

    void resetGame()
    {
        count = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                data[i][j] = 0;
                buttons[i][j].setImageResource(R.drawable.circle);
            }
        }
    }
}