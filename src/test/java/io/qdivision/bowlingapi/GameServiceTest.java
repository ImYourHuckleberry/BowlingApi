//package io.qdivision.bowlingapi;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class GameServiceTest {
//    @Test
//    public void givenNoBowlersExist_whenGetAllBowlers_ReturnEmptyList(){
//        GameService gameService = new GameService(Collections.emptyList());
//        List<Bowler> bowlers = gameService.getAllBowlers();
//        Assert.assertTrue(bowlers.isEmpty());
//
//
//    }
//    @Test
//    public void givenNewBowlerName_whenCreateBowler_thenReturnNewBowler(){
//        String newBowlerName = "Kingsly";
//        GameService gameService = new GameService(new ArrayList<>());
//        Bowler newBowler=gameService.addBowler(newBowlerName);
//        Assert.assertNotNull(newBowler.getId());
//        Assert.assertEquals(newBowlerName, newBowler.getName());
//
//
//    }
//}
