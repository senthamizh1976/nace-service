package com.prog.exercise.naceservice.service;

import com.prog.exercise.naceservice.controller.NaceController;
import com.prog.exercise.naceservice.exception.GlobalErrorCode;
import com.prog.exercise.naceservice.exception.InvalidOrderIdException;
import com.prog.exercise.naceservice.exception.NaceGlobalException;
import com.prog.exercise.naceservice.exception.NoOrderDetailsFoundException;
import com.prog.exercise.naceservice.repository.NacedetailsDao;
import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.validation.NaceValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NaceService implements INaceService {

    Logger logger = LoggerFactory.getLogger(NaceService.class);

    @Autowired
    private NacedetailsDao nacedetailsDao;

    public NaceDetails putNaceDetails(final NaceDetailsDto naceDetails) {
        logger.debug("putNaceDetails-Start");

        NaceValidator.validatePutNaceDetails(naceDetails);
        NaceDetails nace = NaceDetails.fromDto(naceDetails);

        logger.debug("putNaceDetails-End");
        return nacedetailsDao.save(nace);
    }

    public NaceDetails getNaceDetails(Long orderId) {
        logger.debug("getNaceDetails-Start");
        NaceDetails naceDetails = null;
        if ((orderId != null) && (orderId.longValue() > 0)) {
            try {
                naceDetails = nacedetailsDao.findByOrderId(orderId);
            } catch (Exception e) {
                throw new NaceGlobalException(GlobalErrorCode.NAC_SERVICE_SYSTEM_EXCEPTION_ID, "System Exception Occured. Please contact the support team.");
            }

        } else {
            throw new InvalidOrderIdException("Invalid Order Id : "+orderId, GlobalErrorCode.NAC_SERVICE_INVALID_ORDER_ID);
        }

        if (naceDetails == null)
            throw new NoOrderDetailsFoundException(GlobalErrorCode.NAC_SERVICE_NO_ORDER_DETAILS_FOUND, "No Order Details Found. Please check the order id.");

        logger.debug("getNaceDetails-End");
        return naceDetails;
    }
}
