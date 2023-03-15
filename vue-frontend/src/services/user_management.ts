import http from "@/services/http_client";

export class UserManagementService {

    private urlUserList = "/api/user/";
    private urlRoleList = "/api/role/";

    public async findUsers() : Promise<Page<User>> {
        return http.get(this.urlUserList)
            .then(response => Promise.resolve(response.data));
    }

    public async findUserById(id: string) : Promise<User> {
        return http.get(this.urlUserList + `${id}`)
            .then(response => Promise.resolve(response.data));
    }

    public async saveUser(user: User) : Promise<User> {
        if(user.id != null) {
            return http.put(this.urlUserList + `${user.id}`, user)
                .then(response => Promise.resolve(response.data));
        } else {
            return http.post(this.urlUserList, user)
                .then(response => Promise.resolve(response.data));
        }
    }

    public async deleteUserById(id: string) : Promise<void> {
        return http.delete(this.urlUserList + `${id}`)
        .then(response => Promise.resolve(response.data));
    }

    public async findRoles() : Promise<Page<Role>> {
        return http.get(this.urlRoleList)
            .then(response => Promise.resolve(response.data));
    }
}