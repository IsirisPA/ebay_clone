package com.isiris.ebayclone.controller.auction;

import com.isiris.ebayclone.service.AuctionService;
import com.isiris.ebayclone.service.dto.AuctionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;

@RestController
@RequestMapping(value = "/auction", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @GetMapping("/{id}")
    private ResponseEntity<AuctionDto> getAuction(@PathVariable String id) {
        return ResponseEntity.ok(auctionService.getAuction(id));
    }

    @PostMapping
    private ResponseEntity<String> setAuction(@RequestBody AuctionDto auction) {
        return ResponseEntity.ok(auctionService.postAuction(auction));
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> editAuction(@PathVariable String id, @RequestBody AuctionDto auction) {
        return ResponseEntity.ok(auctionService.editAuction(id, auction));
    }

    @DeleteMapping("/{id}")
    private void deleteAuction(@PathVariable String id, Principal principal) {
        auctionService.deleteAuction(id, principal.getName());
    }

    @PostMapping("/{id}/start")
    private ResponseEntity<String> startAuction(@PathVariable String id, Principal principal) {
        return ResponseEntity.ok(auctionService.startAuction(id, principal.getName()));
    }

    @GetMapping("/{id}/open")
    private ResponseEntity<Boolean> startAuction(@PathVariable String id) {
        return ResponseEntity.ok(auctionService.checkAuctionOpen(id));
    }

    @GetMapping(value = "/{id}/download", produces = APPLICATION_OCTET_STREAM)
    @RolesAllowed("admin")
    public ResponseEntity<byte[]> downloadAuctionData(@PathVariable String id, @RequestParam Boolean isJson) {
        return ResponseEntity.ok(auctionService.downloadAuctionData(id, isJson));
    }

}
