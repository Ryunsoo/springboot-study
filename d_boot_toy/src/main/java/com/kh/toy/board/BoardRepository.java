package com.kh.toy.board;

import java.util.List;

import com.kh.toy.common.util.file.FileDTO;

public interface BoardRepository {

	void insertFileInfo(FileDTO fileDTO);
	
	void insertBoard(Board board);

	Board selectBoardIdx(String bdIdx);
	
	List<FileDTO> selectFilesByBdIdx(String bdIdx);
}
