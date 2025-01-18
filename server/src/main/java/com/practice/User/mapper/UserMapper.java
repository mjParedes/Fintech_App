package com.practice.User.mapper;

import com.practice.Cost.dtoRequest.CostRequestDto;
import com.practice.Cost.dtoResponse.CostPageResponseDto;
import com.practice.Cost.model.CostModel;
import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.model.NotificationModel;
import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Recommendation.dtoRequest.RecommendationRequestDto;
import com.practice.Recommendation.dtoResponse.RecommendationPageResponseDto;
import com.practice.Recommendation.model.RecommendationModel;
import com.practice.User.dtoRequest.UserRequestDto;
import com.practice.User.dtoResponse.UserResponseDto;
import com.practice.User.model.RoleModel;
import com.practice.User.model.UserModel;
import com.practice.Wallet.dtoRequest.WalletRequestDto;
import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.model.WalletModel;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Mapea de DTO a entidad
    public UserModel toEntity(UserRequestDto dto) {
        return modelMapper.map(dto, UserModel.class);
    }

    // Mapea de entidad a DTO
    public UserRequestDto toDto(UserModel user) {
        return modelMapper.map(user, UserRequestDto.class);
    }


    public UserResponseDto toDtoUser(UserModel userModel) {
        if (userModel == null) {
            return null;
        }

        // Mapea las propiedades básicas automáticamente
        UserResponseDto dto = modelMapper.map(userModel, UserResponseDto.class);

        // Para listas o campos complejos, puedes usar mapearlos manualmente o configurar mappings personalizados
        dto.setCosts(userModel.getCostModel().stream()
                .map(cost -> modelMapper.map(cost, CostRequestDto.class))
                .collect(Collectors.toList()));

        dto.setWallets(userModel.getWalletModel().stream()
                .map(wallet -> modelMapper.map(wallet, WalletRequestDto.class))
                .collect(Collectors.toList()));

        dto.setNotifications(userModel.getNotificationModel().stream()
                .map(notification -> modelMapper.map(notification, NotificationRequestDto.class))
                .collect(Collectors.toList()));

        dto.setRecommendations(userModel.getRecommendationModel().stream()
                .map(recommendation -> modelMapper.map(recommendation, RecommendationRequestDto.class))
                .collect(Collectors.toList()));

        dto.setPortfolios(userModel.getPortfolioModel().stream()
                .map(portfolio -> modelMapper.map(portfolio, PortfolioRequestDto.class))
                .collect(Collectors.toList()));

        dto.setRoles(userModel.getRoles().stream()
                .map(role -> role.getEnumRole().name())
                .collect(Collectors.toSet()));

        return dto;
    }

//    public UserResponseDto toDtoUser(UserModel userModel) {
//        if (userModel == null) {
//            return null;
//        }
//
//        UserResponseDto dto = new UserResponseDto();
//        dto.setId(userModel.getId());
//        dto.setPhotoUrl(userModel.getPhotoUrl());
//        dto.setEmail(userModel.getEmail());
//        dto.setName(userModel.getName());
//        dto.setLastName(userModel.getLastName());
//        dto.setPhoneNumber(userModel.getPhoneNumber());
//        dto.setBirthDate(userModel.getBirthDate());
//        dto.setRegisterDate(userModel.getRegisterDate());
//        dto.setLastLogin(userModel.getLastLogin());
//
//        // Convert FinancingProfile
//        dto.setFinancingProfile(toFinancingProfileDto(userModel.getFinancingProfile()));
//
//        // Convert Costs
//        dto.setCosts(userModel.getCostModel().stream()
//                .map(this::toCostDto)
//                .collect(Collectors.toList()));
//
//        // Convert Wallets
//        dto.setWallets(userModel.getWalletModel().stream()
//                .map(this::toWalletDto)
//                .collect(Collectors.toList()));
//
//        // Convert Notifications
//        dto.setNotifications(userModel.getNotificationModel().stream()
//                .map(this::toNotificationDto)
//                .collect(Collectors.toList()));
//
//        // Convert Recommendations
//        dto.setRecommendations(userModel.getRecommendationModel().stream()
//                .map(this::toRecommendationDto)
//                .collect(Collectors.toList()));
//
//        // Convert Portfolios
//        dto.setPortfolios(userModel.getPortfolioModel().stream()
//                .map(this::toPortfolioDto)
//                .collect(Collectors.toList()));
//
//        // Convert Roles
//        dto.setRoles(userModel.getRoles().stream()
//                .map(this::toRoleDto)
//                .collect(Collectors.toSet()));
//
//        return dto;
//    }
//
//
//    private FinancingProfileRequestDto toFinancingProfileDto(FinancingProfileModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        return new FinancingProfileRequestDto(
//                model.getId(),
//                model.getEnumKnowledgeLevel().name(),
//                model.getEnumRiskProfile().name(),
//                model.getIncomeMonthly(),
//                model.getExpensesMonthly(),
//                model.getPercentageSave(),
//                model.getTotalDebt(),
//                model.getSavingsTotal(),
//                model.getPatrimonyTotal()
//        );
//    }
//
//    private CostRequestDto toCostDto(CostModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        CostRequestDto dto = new CostRequestDto();
//        dto.setId(model.getId());
//        dto.setUserId(model.getUser().getId());
//        dto.setType(model.getType());
//        dto.setDescription(model.getDescription());
//        dto.setCategory(model.getCategory());
//        dto.setAmount(model.getAmount());
//
//        return dto;
//    }
//
//
//    private WalletRequestDto toWalletDto(WalletModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        WalletRequestDto dto = new WalletRequestDto();
//        dto.setId(model.getId());
//        dto.setUserId(model.getUser().getId());
//        dto.setCurrentBalance(model.getCurrentBalance());
//
//        return dto;
//    }
//
//    private NotificationRequestDto toNotificationDto(NotificationModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        NotificationRequestDto dto = new NotificationRequestDto();
//        dto.setId(model.getId());
//        dto.setUserId(model.getUser().getId());
//        dto.setTypeNotification(model.getType().name());
//        dto.setMessage(model.getMessage());
//        dto.setIsRead(model.getIsRead());
//
//        return dto;
//    }
//
//    private RecommendationRequestDto toRecommendationDto(RecommendationModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        RecommendationRequestDto dto = new RecommendationRequestDto();
//        dto.setId(model.getId());
//        dto.setUserId(model.getUser().getId());
//        dto.setRecommendationType(model.getEnumRecommendationType().name());
//        dto.setState(model.getState());
//        dto.setMotion(model.getMotion());
//        dto.setInstrumentId(model.getInstrument().getId());
//
//        return dto;
//    }
//
//    private PortfolioRequestDto toPortfolioDto(PortfolioModel model) {
//        if (model == null) {
//            return null;
//        }
//
//        PortfolioRequestDto dto = new PortfolioRequestDto();
//        dto.setId(model.getId());
//        dto.setUserId(model.getUser().getId());
//        dto.setInstrumentId(model.getInstrument().getId());
//        dto.setQuantity(model.getQuantity());
//        dto.setPriceBuy(model.getPriceBuy());
//
//        return dto;
//    }
//
//    private String toRoleDto(RoleModel role) {
//        if (role == null) {
//            return null;
//        }
//        return role.getEnumRole().name();
//    }



}
