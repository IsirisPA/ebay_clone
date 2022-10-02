package com.isiris.ebayclone.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.isiris.ebayclone.repository.AuctionRepository;
import com.isiris.ebayclone.repository.entities.auction.AuctionEntity;
import com.isiris.ebayclone.service.AuctionService;
import com.isiris.ebayclone.service.dto.AuctionDto;
import com.isiris.ebayclone.service.mapper.AuctionMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final AuctionMapper auctionMapper;

    @Override
    public AuctionDto getAuction(String id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(auctionMapper::toDto).orElseThrow(RuntimeException::new);
    }

    @Override
    public String postAuction(AuctionDto auction) {
        return auctionRepository.save(auctionMapper.toEntity(auction)).getId();
    }

    @Override
    public void deleteAuction(String id, String userId) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findByIdAndSellerId(id, userId);
        auctionEntity.ifPresent(auctionRepository::delete);
    }

    @Override
    public String editAuction(String id, AuctionDto auctionDto) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(entity -> {
            AuctionEntity newAuctionEntity = auctionMapper.toEntity(auctionDto);
            newAuctionEntity.setId(entity.getId());
            return auctionRepository.save(newAuctionEntity).getId();
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public String startAuction(String id, String userId) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findByIdAndSellerId(id, userId);
        return auctionEntity.map(entity -> {
            if (ObjectUtils.isEmpty(entity.getStarted())) {
                entity.setStarted(LocalDateTime.now());
                entity.setEnds(LocalDateTime.now().plusDays(1));
                return auctionRepository.save(entity).getId();
            } else throw new RuntimeException();
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public Boolean checkAuctionOpen(String id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(entity ->
                        entity.getEnds().compareTo(LocalDateTime.now()) > -1)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public byte[] downloadAuctionData(String id, Boolean isJson) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(entity ->
                        buildFile(isJson, entity)
                )
                .orElseThrow(RuntimeException::new);
    }

    private byte[] buildFile(Boolean isJson, AuctionEntity entity) {
        if (isJson) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(auctionMapper.toDto(entity));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            XmlMapper mapper = new XmlMapper();
            try {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(auctionMapper.toDto(entity));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}