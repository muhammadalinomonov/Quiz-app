package uz.gita.myquizapp.play.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.myquizapp.R;
import uz.gita.myquizapp.play.model.TestData;

public class AppRepository {
    private List<TestData> list;
    private List<TestData>oldList;
    private List<Integer>states;

    private List<Integer>indexesOfAnswers;
    private List<Integer> indexesOfChecked;
    List<String> answers;
    int correctCount;
    int wrongCount;
    int skipCount;

    private static AppRepository repository;

    public void loadTest() {
        list = new ArrayList<>();
        list.add(new TestData("Polshaning poytaxti?", "Varshava", "Parij", "Rim", "Sochi", "Varshava", R.drawable.polsha));
        list.add(new TestData("Italiyaning poytaxti?", "Varshava", "Parij", "Rim", "Sochi", "Rim", R.drawable.italiya));
        list.add(new TestData("Niderlandiya poytaxti?", "Dublin", "Amsterdam", "Valetta", "Vena", "Amsterdam", R.drawable.niderlandiya));
        list.add(new TestData("Gretsiyaning poytaxti?", "Dublin", "Afina", "Vena", "Amsterdam", "Afina", R.drawable.gretsiya));
        list.add(new TestData("Portugaliya poytaxti?", "Lissabon", "Dublin", "Afina", "Monako", "Lissabon", R.drawable.portugaliya));
        list.add(new TestData("O'zbekiston poytaxti?", "O'sh", "Andijon", "Toshkent", "Qashqadaryo", "Toshkent", R.drawable.uzb));
        list.add(new TestData("Hindiston poytaxti?", "Agra", "Bxiali", "Jamnagar", "Dehli", "Dehli", R.drawable.hind));
        list.add(new TestData("Qatar poytaxti?", "Doha", "Dublin", "Afina", "Monako", "Doha", R.drawable.qatar));
        list.add(new TestData("Eron poytaxti?", "Lissabon", "Dublin", "Tehron", "Monako", "Tehron", R.drawable.eron));
        list.add(new TestData("Fransiya poytaxti?", "Lissabon", "Parij", "Afina", "Monako", "Parij", R.drawable.fransiya));
        list.add(new TestData("Litva poytaxti?", "Vilnyus", "Riga", "kiyev", "Sofiya", "Vilnyus", R.drawable.litva));
        list.add(new TestData("Ruminiya poytaxti?", "Vilnyus", "Buxarest", "Vena", "Viktoriya", "Buxarest", R.drawable.ruminiya));
        list.add(new TestData(" Shveysariya poytaxti?", "Vilnyus", "Buxarest", "Vena", "Bern", "Bern", R.drawable.shveysariya));
        list.add(new TestData("Ummon poytaxti?", "Damashq", "Dakka", "Islomobod", "Maskat", "Maskat", R.drawable.ummon));
        list.add(new TestData("Quvayt poytaxti?", "Dakka", "Tehron", "Al-Quvayt", "Viktoriya", "Al-Quvayt", R.drawable.quvayt));
        list.add(new TestData("Saudiya Arabistoni poytaxti?", "Ar-Riyod",  "Al-Jubayl", "Makka", "Jidda", "Ar-Riyod", R.drawable.saudiya));
        list.add(new TestData("Argentina poytaxti?", "Gavana", "Buenos Ayres", "Vena", "Ottava", "Buenos Ayres", R.drawable.argentina));
        list.add(new TestData("Kanada poytaxti?", "Vilnyus", "Buenos Ayres", "Ottava", "Vena", "Ottava", R.drawable.kanada));
        list.add(new TestData("Urugvay poytaxti?", "Montevideo", "Ottava", "Vena", "Rozo", "Montevideo", R.drawable.urugvay));
    }

    private AppRepository() {
        loadTest();
    }

    public void shuffle() {
        Collections.shuffle(list);
    }

    public static AppRepository getInstance() {
        if (repository == null)
            repository = new AppRepository();
        return repository;
    }

    public List<TestData> getNeedDataByCount(int count) {
        oldList = list.subList(0, count);
        return oldList;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }

    public int getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(int skipCount) {
        this.skipCount = skipCount;
    }


    public List<TestData> getOldList() {
        return oldList;
    }

    public void setOldListState(List<Integer> states) {
        this.states = states;
    }

    public List<Integer> getStates() {
        return states;
    }

    public List<Integer> getIndexesOfAnswers() {
        return indexesOfAnswers;
    }

    public List<Integer> getIndexesOfChecked() {
        return indexesOfChecked;
    }

    public void setIndexesOfAnswers(List<Integer> indexesOfAnswers) {
        this.indexesOfAnswers = indexesOfAnswers;
    }

    public void setIndexesOfChecked(List<Integer> indexesOfChecked) {
        this.indexesOfChecked = indexesOfChecked;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
