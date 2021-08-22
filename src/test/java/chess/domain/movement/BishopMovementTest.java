package chess.domain.movement;

import chess.domain.board.Board;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import chess.domain.state.Ready;
import chess.game.ChessGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BishopMovementTest {

    private Board board;

    @BeforeEach
    void before() {
        Ready ready = new Ready();
        ChessGame chessGame = ChessGame.of(ready, ready.board());
        board = chessGame.board();
    }

    @Test
    @DisplayName("비숍의 이동 규칙에 따라 종,횡으로 이동 가능한 위치를 반환한다.")
    void movable_positions() {
        //given
        Piece bishop = board.from(Position.from("c1"));
        List<Position> exceptPosition = Arrays.asList(Position.from("d2"), Position.from("e3"), Position.from("f4"),
                Position.from("g5"), Position.from("h6"), Position.from("b2"),
                Position.from("a3"));

        //when
        List<Position> movablePositions = bishop.getMovablePositions();

        //then
        movablePositions.forEach(movable -> assertThat(exceptPosition.contains(movable)).isTrue());
    }
}