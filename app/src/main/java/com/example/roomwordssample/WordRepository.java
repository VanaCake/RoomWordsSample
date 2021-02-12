package com.example.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDataBase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    public void insert(Word word){
        new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao asyncTaskDao;

        insertAsyncTask(WordDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
