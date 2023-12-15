import org.example.Question;
import org.example.QuestionServices;
import org.example.QuestionSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuestionServicesTest {
    QuestionServices questionServices = new QuestionServices();
    QuestionSet questionSetTest = null;

    @Test
    public void question_services_pulls_correct_number_of_questions () throws Exception {
        questionSetTest = questionServices.getAll(9, "easy");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The incorrect number of questions was pulled from the API", testQuestions.length, 10);
    }
    @Test
    public void test_difficulty_field_pulls_correct_value_for_easy () throws Exception {
        questionSetTest = questionServices.getAll(9, "easy");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The easy question was not the correct difficulty", testQuestions[0].getDifficulty(), "easy");
    }

    @Test
    public void test_difficulty_field_pulls_correct_value_for_medium () throws Exception {
        questionSetTest = questionServices.getAll(9, "medium");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The medium question was not the correct difficulty", testQuestions[0].getDifficulty(), "medium");
    }

    @Test
    public void test_difficulty_field_pulls_correct_value_for_hard () throws Exception {
        questionSetTest = questionServices.getAll(9, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The hard question was not the correct difficulty", testQuestions[0].getDifficulty(), "hard");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_general_knowledge () throws Exception {
        questionSetTest = questionServices.getAll(9, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The general knowledge question did not have the right category", testQuestions[0].getCategory(), "General Knowledge");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_books () throws Exception {
        questionSetTest = questionServices.getAll(10, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The books question did not have the right category", testQuestions[0].getCategory(), "Entertainment: Books");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_movies () throws Exception {
        questionSetTest = questionServices.getAll(11, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The movies question did not have the right category", testQuestions[0].getCategory(), "Entertainment: Film");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_music () throws Exception {
        questionSetTest = questionServices.getAll(12, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The music question did not have the right category", testQuestions[0].getCategory(), "Entertainment: Music");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_television () throws Exception {
        questionSetTest = questionServices.getAll(14, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The television question did not have the right category", testQuestions[0].getCategory(), "Entertainment: Television");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_video_games () throws Exception {
        questionSetTest = questionServices.getAll(15, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The video games question did not have the right category", testQuestions[0].getCategory(), "Entertainment: Video Games");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_sports () throws Exception {
        questionSetTest = questionServices.getAll(21, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The sports question did not have the right category", testQuestions[0].getCategory(), "Sports");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_animals () throws Exception {
        questionSetTest = questionServices.getAll(27, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The animals question did not have the right category", testQuestions[0].getCategory(), "Animals");
    }

    @Test
    public void test_category_field_pulls_correct_value_for_science () throws Exception {
        questionSetTest = questionServices.getAll(17, "hard");
        Question [] testQuestions = questionSetTest.getQuestions();

        Assert.assertEquals("The science question did not have the right category", testQuestions[0].getCategory(), "Science &amp; Nature");
    }
}
