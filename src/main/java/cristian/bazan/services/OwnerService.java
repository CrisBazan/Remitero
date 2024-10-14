package cristian.bazan.services;

import cristian.bazan.dtos.OwnerDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

    OwnerDto getOwner();
    OwnerDto updateOrCreateOwner(OwnerDto ownerDto);
}
