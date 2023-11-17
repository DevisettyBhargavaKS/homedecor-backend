package com.CodeWithBhargav.controller.Admin;

import com.CodeWithBhargav.model.AppUser;
import com.CodeWithBhargav.model.Role;
import com.CodeWithBhargav.response.common.APIResponse;
import com.CodeWithBhargav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminUserController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {
        List<AppUser> appUsers = userService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUsers);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
