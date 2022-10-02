package com.isiris.ebayclone.controller.auction;

import com.isiris.ebayclone.service.BidService;
import com.isiris.ebayclone.service.dto.BidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/auction/{id}/bid", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping
    public ResponseEntity<String> bidToAuction(@PathVariable String id, @RequestBody BidDto bidDto) {
        return ResponseEntity.ok(bidService.bidToAuction(id, bidDto));
    }

    @GetMapping
    public ResponseEntity<List<BidDto>> getAllBidsOfAuction(@PathVariable String id) {
        return ResponseEntity.ok(bidService.getBidsOfAuction(id));
    }

    @GetMapping("/{bidId}")
    public ResponseEntity<BidDto> getBidOfAuction(@PathVariable String bidId) {
        return ResponseEntity.ok(bidService.getBidOfAuction(bidId));
    }
}
