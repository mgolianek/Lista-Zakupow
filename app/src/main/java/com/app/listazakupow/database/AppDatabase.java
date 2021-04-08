package com.app.listazakupow.database;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.listazakupow.R;
import com.app.listazakupow.models.dao.CategoryDao;
import com.app.listazakupow.models.dao.OrderDao;
import com.app.listazakupow.models.dao.ProductDao;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.models.other.Converters;
import com.app.listazakupow.util.App;

@Database(entities = {
        CategoryEntity.class,
        OrderEntity.class,
        ProductEntity.class},
        version = 1,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract CategoryDao categoryDao();

    public abstract ProductDao productDao();

    public abstract OrderDao orderDao();

    public static AppDatabase getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (AppDatabase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(App.getContext(),
                        AppDatabase.class, "app_db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //little cheat, to be able to call database calls from main thread, shouldn't affect app speed in our case
                        .addCallback(roomCallback)
                        .build();
            }
            return instance;
        }
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private final CategoryDao categoryDao;
        private final ProductDao productDao;
        private final OrderDao orderDao;

        private  PopulateDBAsyncTask(AppDatabase db) {
            categoryDao = db.categoryDao();
            productDao = db.productDao();
            orderDao = db.orderDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insert(new CategoryEntity("Nabiał", R.drawable.ic_dairy));
            categoryDao.insert(new CategoryEntity("Pieczywo", R.drawable.ic_bread));
            categoryDao.insert(new CategoryEntity("Warzywa", R.drawable.ic_vegetables));
            categoryDao.insert(new CategoryEntity("Owoce", R.drawable.ic_fruit));
            categoryDao.insert(new CategoryEntity("Mięso", R.drawable.ic_meat));
            categoryDao.insert(new CategoryEntity("Ryba", R.drawable.ic_fish));
            categoryDao.insert(new CategoryEntity("Wędliny i podroby", R.drawable.ic_offal));
            categoryDao.insert(new CategoryEntity("Zioła i przyprawy", R.drawable.ic_herbs));
            categoryDao.insert(new CategoryEntity("Śniadanie", R.drawable.ic_breakfast));
            categoryDao.insert(new CategoryEntity("Makarony i sypkie", R.drawable.ic_pasta));
            categoryDao.insert(new CategoryEntity("Oleje i tłuszcze", R.drawable.ic_oil));
            categoryDao.insert(new CategoryEntity("Przetwory", R.drawable.ic_preserves));
            categoryDao.insert(new CategoryEntity("Dania gotowe i sosy", R.drawable.ic_readyfood));
            categoryDao.insert(new CategoryEntity("Mrożone", R.drawable.ic_freezed));
            categoryDao.insert(new CategoryEntity("Słodycze i przekąski", R.drawable.ic_sweets));
            categoryDao.insert(new CategoryEntity("Napoje", R.drawable.ic_drink_no_alcohol));
            categoryDao.insert(new CategoryEntity("Pielęgnacja i czystość", R.drawable.ic_care));
            categoryDao.insert(new CategoryEntity("Alkohole i używki", R.drawable.ic_alcohol));
            categoryDao.insert(new CategoryEntity("Kawa i herbata", R.drawable.ic_coffe));
            categoryDao.insert(new CategoryEntity("Inne", R.drawable.ic_add));


            productDao.insert(new ProductEntity("Produkt1", "Przetwory"));
            productDao.insert(new ProductEntity("Produkt2", "Przetwory"));
            productDao.insert(new ProductEntity("Produkt3", "Przetwory"));


//            orderDao.insert(new OrderEntity());

            return null;
        }
    }
}