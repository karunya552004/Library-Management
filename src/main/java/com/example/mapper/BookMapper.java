package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.dto.BookRequestDTO;
import com.example.dto.BookResponseDTO;
import com.example.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toBook(BookRequestDTO dto);

    BookResponseDTO toResponseDTO(Book book);
}