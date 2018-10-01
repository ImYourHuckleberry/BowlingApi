//package io.qdivision.bowlingapi;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class GameControllerTest {
//
//    @Mock
//    private GameService gameService;
//
//
//    @Test
//    public void givenNoBowler_whenGetAllBowlers_thenReturnEmptyList(){
//
//        Mockito.when(gameService.getAllBowlers())
//                .thenReturn(new ArrayList<>());
//
//        GameController gameController= new GameController(gameService);
//
//        ResponseEntity<List<Bowler>> response = gameController.getAllBowlers();
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assert.assertTrue(response.getBody().isEmpty());
//    }
//
//
//
//
//@Test
//public void givenBowlerExists_whenGetAllBowlers_returnList(){
//        ArrayList<Bowler> bowlers = new ArrayList<>();
//        Bowler bowler = new Bowler();
//        bowlers.add(bowler);
//        Mockito.when(gameService.getAllBowlers()).thenReturn(bowlers);
//
//        GameController gameController= new GameController(gameService);
//
//        ResponseEntity<List<Bowler>> response = gameController.getAllBowlers();
//
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assert.assertFalse(response.getBody().isEmpty());
//
//}
//
//@Test
//    public void givenNewBowler_whenAddBowler_thenNewBowlerReturned(){
//    SingleFrame singleFrame = new SingleFrame(0,0,0);
//    Frames frame[]=new Frames[10];
//        String bowlerName="Kingsly";
//        Bowler expectedBowler = new Bowler(1, bowlerName, frame[0]);
//    Mockito.when(gameService.addBowler(bowlerName)).thenReturn(expectedBowler);
//    GameController gameController = new GameController(gameService);
//    Bowler bowler=new Bowler(null, bowlerName, null);
//    ResponseEntity <Bowler> response = gameController.addBowler(bowler);
//    Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    Assert.assertEquals(bowlerName, response.getBody().getName());
//    Assert.assertNotNull(response.getBody().getId());
//}
//}
//
