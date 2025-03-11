package jayden.usaco;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/// This is your 2nd hw! 
/// for testing, run `./script/java04-test.sh`, 
/// then, you can check up why you got wrong test results here!
/// 
/// Your goal is to get 100% passing!


public class Exercise02Test {

    // Test cases for skillLevel
    @Test
    public void testSkillLevelBeginner() {
        assertEquals("Beginner", Exercise02.skillLevel(13));
    }

    @Test
    public void testSkillLevelModerate() {
        assertEquals("Moderate", Exercise02.skillLevel(50));
    }

    @Test
    public void testSkillLevelAdvanced() {
        assertEquals("Advanced", Exercise02.skillLevel(78));
    }

    @Test
    public void testSkillLevelEdgeCaseBeginner() {
        assertEquals("Beginner", Exercise02.skillLevel(25));
    }

    @Test
    public void testSkillLevelEdgeCaseModerateLowerBound() {
        assertEquals("Moderate", Exercise02.skillLevel(26));
    }

    @Test
    public void testSkillLevelEdgeCaseModerateUpperBound() {
        assertEquals("Moderate", Exercise02.skillLevel(75));
    }

    @Test
    public void testSkillLevelEdgeCaseAdvanced() {
        assertEquals("Advanced", Exercise02.skillLevel(76));
    }

    // Test cases for bookStore
    @Test
    public void testBookStoreSufficientFunds() {
        assertEquals("226.48", Exercise02.bookStore("Shirt", 350.48, 8));
    }

    @Test
    public void testBookStoreInsufficientFunds() {
        assertEquals("Not enough money!", Exercise02.bookStore("Lanyard", 200.0, 70));
    }

    @Test
    public void testBookStoreSingleItem() {
        assertEquals("75.00", Exercise02.bookStore("Sweatshirt", 100.0, 1));
    }

    @Test
    public void testBookStoreExactAmount() {
        assertEquals("0.00", Exercise02.bookStore("Shirt", 31.0, 2));
    }

    @Test
    public void testBookStoreInsufficientFundsEdgeCase() {
        assertEquals("Not enough money!", Exercise02.bookStore("Mug", 5.0, 1));
    }

    // Test cases for dinnerPlans
    @Test
    public void testDinnerPlansSlightlyHungryWalk() {
        assertEquals("Walk", Exercise02.dinnerPlans(4, "Slightly Hungry"));
    }

    @Test
    public void testDinnerPlansVeryHungryUber() {
        assertEquals("Uber", Exercise02.dinnerPlans(6, "Very Hungry"));
    }

    @Test
    public void testDinnerPlansVeryHungryWalkEdgeCase() {
        assertEquals("Walk", Exercise02.dinnerPlans(1, "Very Hungry"));
    }

    @Test
    public void testDinnerPlansNotHungryWalkEdgeCase() {
        assertEquals("Walk", Exercise02.dinnerPlans(7, "Not Hungry"));
    }

    @Test
    public void testDinnerPlansNotHungryUber() {
        assertEquals("Uber", Exercise02.dinnerPlans(8, "Not Hungry"));
    }

    // Test cases for weekendTrip
    @Test
    public void testWeekendTripDriving() {
        assertEquals("driving", Exercise02.weekendTrip(7.0, 46.66, 1.0));
    }

    @Test
    public void testWeekendTripTooMuchTime() {
        assertEquals("Going to this destination would take too much time.", Exercise02.weekendTrip(10.0, 5.0, 8.0));
    }

    @Test
    public void testWeekendTripWalking() {
        assertEquals("walking", Exercise02.weekendTrip(1.0, 3.0, 5.0));
    }

    @Test
    public void testWeekendTripBiking() {
        assertEquals("biking", Exercise02.weekendTrip(3.0, 20.0, 1.0));
    }

    @Test
    public void testWeekendTripTimeExceeded() {
        assertEquals("Going to this destination would take too much time.", Exercise02.weekendTrip(50.0, 60.0, 3.0));
    }

    // Test cases for textFriends
    @Test
    public void testTextFriendsDriving() {
        assertEquals("If each of us gets 5 snack(s), there will be 2 left. I will be driving, who else is doing the same?",
                Exercise02.textFriends(25.0, 65.0, 2.5, 17, 3));
    }

    @Test
    public void testTextFriendsWalking() {
        assertEquals("If each of us gets 1 snack(s), there will be 6 left. I will be walking, who else is doing the same?",
                Exercise02.textFriends(1.5, 2.5, 3.0, 13, 7));
    }

    @Test
    public void testTextFriendsInfeasibleTrip() {
        assertEquals("Going to this destination would take too much time.",
                Exercise02.textFriends(50.0, 25.0, 2.0, 20, 4));
    }

    @Test
    public void testTextFriendsExcessSnacks() {
        assertEquals("If each of us gets 0 snack(s), there will be 10 left. I will be biking, who else is doing the same?",
                Exercise02.textFriends(10.0, 18.0, 3.0, 10, 20));
    }
}