package com.geeks.homeapp6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

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

    private UserAdapter userAdapter;

    private CarAdapter carAdapter;

    private ArrayList<User> users;

    private ArrayList<Car> cars;

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

        userAdapter = new UserAdapter(users, new UserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user, int position) {
                if (position > 0){
                    User clicedUser = users.get(position);
                    users.remove(position);
                    users.add(0, clicedUser);
                    userAdapter.notifyItemMoved(position, 0);
                    binding.recyclerView.scrollToPosition(0);
                }
            }
        });


        binding.recyclerView.setAdapter(userAdapter);
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

        carAdapter = new CarAdapter(cars, (car, position) -> {
            if (position > 0){
                Car clicedCar = cars.get(position);
                cars.remove(position);
                cars.add(0, clicedCar);
                carAdapter.notifyItemMoved(position, 0);
                binding.recyclerView.scrollToPosition(0);
            }
        });
        binding.recyclerView2.setAdapter(carAdapter);
        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.HORIZONTAL, false));

        binding.EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 String query = s.toString().trim();
                 findAndMoveItem(query);
                 findAndMoveItem2(query);

            }
        });


    }

     private void findAndMoveItem(String query){
        if (userAdapter == null || users.isEmpty()) return;

        if (query.isEmpty()){
            for (User u : users){
                u.setSelected2(false);
            }
            userAdapter.notifyDataSetChanged();
            return;
        }
        String lowerCaseQuery = query.toLowerCase();
        int matchIndex = -1;
        User matchedUser = null;
        for (int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if (user.getModel().toLowerCase().contains(lowerCaseQuery)){
                matchIndex = i;
                matchedUser = user;
                break;
            }
        }

        if (matchIndex != -1 && matchedUser != null){
            for (User u : users){
                u.setSelected2(false);
            }
            matchedUser.setSelected2(true);
            if (matchIndex > 0){
                users.remove(matchIndex);
                users.add(0, matchedUser);
                userAdapter.notifyItemMoved(matchIndex, 0);
                binding.recyclerView.scrollToPosition(0);
            }
            userAdapter.notifyDataSetChanged();
        }
     }



    private void findAndMoveItem2(String query){
        if (carAdapter == null || cars.isEmpty()) return;

        if (query.isEmpty()){
            for (Car c : cars){
                c.setSelected(false);
            }
            carAdapter.notifyDataSetChanged();
            return;
        }
        String lowerCaseQuery = query.toLowerCase();
        int matchIndex = -1;
        Car matchedCar = null;
        for (int i = 0; i < cars.size(); i++){
            Car car = cars.get(i);
            if (car.getName().toLowerCase().contains(lowerCaseQuery)){
                matchIndex = i;
                matchedCar = car;
                break;
            }
        }

        if (matchIndex != -1 && matchedCar != null){
            for (Car c : cars){
                c.setSelected(false);
            }
            matchedCar.setSelected(true);
            if (matchIndex > 0){
                cars.remove(matchIndex);
                cars.add(0, matchedCar);
                carAdapter.notifyItemMoved(matchIndex, 0);
                binding.recyclerView2.scrollToPosition(0);
            }
            carAdapter.notifyDataSetChanged();
        }
    }





}