package com.prog.exercise.naceservice.service;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.exception.GlobalErrorCode;
import com.prog.exercise.naceservice.exception.InvalidOrderIdException;
import com.prog.exercise.naceservice.exception.NaceGlobalException;
import com.prog.exercise.naceservice.exception.NoOrderDetailsFoundException;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.repository.NacedetailsDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface INaceService {

    public NaceDetails putNaceDetails(final NaceDetailsDto naceDetails);

    public NaceDetails getNaceDetails(Long orderId);
}
