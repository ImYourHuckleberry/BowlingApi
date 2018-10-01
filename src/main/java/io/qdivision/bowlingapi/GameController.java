package io.qdivision.bowlingapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames() {

        List<Game> games = gameService.getAllGames();

        return ResponseEntity.ok(games);
    }

    @GetMapping(path = "/games/{gameId}")
    public ResponseEntity<List<Game>> getGame(@PathVariable(value = "gameId") int gameId) {

        List<Game> game = gameService.getGame(gameId);

        return ResponseEntity.ok(game);
    }

    @GetMapping("/games/{gameId}/bowlers")
    public ResponseEntity<List<Bowler>> getAllFrameBowlers(@PathVariable(value = "gameId") int gameId) {
        List<Game> game = gameService.getGame(gameId);
        List<Bowler> bowlers = game.get(0).getBowlers();
        return ResponseEntity.ok(bowlers);
    }

    @GetMapping("/games/{gameId}/bowlers/{bowlerId}")
    public ResponseEntity<List<Bowler>> getBowler(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId) {
        List<Bowler> bowler = gameService.getBowler(gameId, bowlerId);
        return ResponseEntity.ok(bowler);
    }

    @GetMapping("/games/{gameId}/bowlers/{bowlerId}/frames")
    public ResponseEntity<List<Frame>> getAllFrames(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId) {
        List<Bowler> bowler = gameService.getBowler(gameId, bowlerId);

        return ResponseEntity.ok(bowler.get(0).getFrames());
    }

    @GetMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}")
    public ResponseEntity<List<Frame>> getFrame(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId) {
        List<Frame> bowlerFrame = gameService.getAFrame(gameId, bowlerId, frameId);
        return ResponseEntity.ok(bowlerFrame);

    }


    @PutMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}/firstRoll")
    public ResponseEntity<List<Frame>> updateFirstRoll(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId, @RequestBody Map<String, Integer> rollValues) {


        Integer firstRoll = rollValues.get("roll");
        List<Frame> updatedFrame = gameService.updateFrameRoll(gameId, bowlerId, frameId, "FIRSTROLL", firstRoll);
        return ResponseEntity.ok(updatedFrame);

    }

    @PutMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}/secondRoll")
    public ResponseEntity<List<Frame>> updateSecondRoll(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId, @RequestBody Map<String, Integer> rollValues) {

        Integer secondRoll = rollValues.get("roll");

        List<Frame> updatedFrame = gameService.updateFrameRoll(gameId, bowlerId, frameId, "SECONDROLL", secondRoll);
        return ResponseEntity.ok(updatedFrame);

    }

    @PutMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}/rollValues")
    public ResponseEntity<List<Frame>> updateBowlerRoll(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId, @RequestBody Map<String, Integer> rollValues) {


        Integer firstRoll = rollValues.get("firstRoll");
        Integer secondRoll = rollValues.get("secondRoll");


        List<Frame> updatedFrame = gameService.updateFrameRoll(gameId, bowlerId, frameId, firstRoll, secondRoll);
        return ResponseEntity.ok(updatedFrame);

    }


    @PostMapping("/games")
    public ResponseEntity<Game> createGame(@RequestBody Map<String, String> bowlerNames) {
        //List<Game> newGame  = gameService.addGame(bowlerNames.get("bowlerName")))
        List<String> gameBowlerNames = new ArrayList<>(bowlerNames.values());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gameService.addGame(gameBowlerNames));


    }


    @PutMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}/firstExtraRoll")
    public ResponseEntity<List<Frame>> updateThirdRoll(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId, @RequestBody Map<String, Integer> rollValues) {

        Integer firstRoll = rollValues.get("firstRoll");

        List<Frame> updatedFrame = gameService.updateFrameRoll(gameId, bowlerId, frameId, "FIRSTEXTRAROLL", firstRoll);
        return ResponseEntity.ok(updatedFrame);

    }

    @PutMapping("/games/{gameId}/bowlers/{bowlerId}/frames/{frameId}/secondExtraRoll")
    public ResponseEntity<List<Frame>> updateFourthRoll(@PathVariable(value = "gameId") int gameId, @PathVariable(value = "bowlerId") int bowlerId, @PathVariable(value = "frameId") int frameId, @RequestBody Map<String, Integer> rollValues) {

        Integer firstRoll = rollValues.get("firstRoll");

        List<Frame> updatedFrame = gameService.updateFrameRoll(gameId, bowlerId, frameId, "SECONDEXTRAROLL", firstRoll);
        return ResponseEntity.ok(updatedFrame);

    }

}

