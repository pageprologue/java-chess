package chess.domain.view;

import chess.domain.piece.Piece;
import chess.domain.position.Position;
import chess.dto.ChessGameDto;

import java.util.Map;

public class OutputView {
    private static final int FILE_SIZE = 8;

    private OutputView() {

    }

    public static void printStartMessage() {
        System.out.println("> 체스 게임을 시작합니다.\n" +
                "> 게임 시작 : start\n" +
                "> 게임 종료 : end\n" +
                "> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }

    public static void printChessBoard(ChessGameDto chessGameDto) {
        Map<Position, Piece> board = chessGameDto.getBoard();
        board.keySet().forEach(position -> {
            System.out.print(board.get(position).symbol());
            separateLine(position);
        });
    }

    private static void separateLine(Position position) {
        if (position.getFileNumber() / FILE_SIZE == 1) {
            System.out.println();
        }
    }
}