package com.geeks.homeapp6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.geeks.homeapp6.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user1 = new User("BMW", 2010, "https://w7.pngwing.com/pngs/619/81/png-transparent-car-porsche-spare-part-auto-compact-car-sedan-car-thumbnail.png");
        User user2 = new User("AUDI", 2020, "https://free-png.ru/wp-content/uploads/2020/11/BBSc270-2b998013.png");
        User user3 = new User("TOYOTA", 2015, "https://w7.pngwing.com/pngs/610/14/png-transparent-car-car-black-car-clipart.png");
        User user4 = new User("CHEVROLE", 2000, "https://cdn.pixabay.com/photo/2015/10/01/17/17/car-967387_1280.png");
        User user5 = new User("MUSTANG", 1980, "https://galerey-room.ru/images/0_6c77d_1e736c1a_orig.png");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        UserAdapter adapter = new UserAdapter(users);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));


        Car car1 = new Car("CARS", "https://vehicle-images.dealerinspire.com/cdaf-110008689/thumbnails/large/1FA6P8CF8S5402512/a1acb198906e6daaa3fde62fc36d2bb0.jpg");
        Car car2 = new Car("SPORTCARS", "https://i.ytimg.com/vi/zEr-mm8OSGo/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLAm0vvR3Ud4t5gSl4BF1LoxWA70Cw");
        Car car3 = new Car("LUXURY", "https://www.motoringresearch.com/wp-content/uploads/2025/03/000-Best-Luxury-Cars-to-Buy.jpg");
        Car car4 = new Car("EXPENSIVE", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVboYLPK3LsTxq65X_qk8hF7lRjdWnUAOtXw31wRPMAYHg0l3-eynnwedLY0p7B3kynEw&usqp=CAU");
        Car car5 = new Car("MONSTRCARS", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0Q55nFKYqGXC7x5MJsriFQZ7ZuByMUgs4bg&s");


        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        CarAdapter adapter1 = new CarAdapter(cars);
        binding.recyclerView2.setAdapter(adapter1);
        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));


    }

}