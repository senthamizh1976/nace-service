package com.prog.exercise.naceservice.validation;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.exception.GlobalErrorCode;
import com.prog.exercise.naceservice.exception.InvalidRequestException;
import com.prog.exercise.naceservice.exception.NoOrderDetailsFoundException;
import org.springframework.stereotype.Component;

@Component
public class NaceValidator {
    public static void validatePutNaceDetails (final NaceDetailsDto naceDetails) {
        if ((naceDetails == null) ||  (naceDetails.getOrder() <= 0) ||  (naceDetails.getLevel() <= 0)
                ||  (naceDetails.getCode() == null ||  naceDetails.getCode().length() <= 0) ||
                (naceDetails.getDescription() == null ||  naceDetails.getDescription().length() <= 0) ||
                (naceDetails.getItemIncludes() == null ||  naceDetails.getItemIncludes().length() <= 0) ||
                (naceDetails.getRefToIsic() == null ||  naceDetails.getRefToIsic().length() <= 0)
        ) {
            throw new InvalidRequestException(GlobalErrorCode.NAC_SERVICE_INVALID_REQUEST_FOUND, "Invald Nace Request. Please check the mandatory fields [Order, Level, Code, Description, Item Includes and Reference]");
        }
    }
}
