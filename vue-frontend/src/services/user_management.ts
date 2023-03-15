import http from "@/services/http_client";

export class UserManagementService {

    private urlUserList = "/api/user/";

    public async findUsers() : Promise<Page<User>> {
        return http.get(this.urlUserList)
            .then(response => Promise.resolve(response.data));
    }

    public async findById(id: string) : Promise<User> {
        return http.get(this.urlUserList + `/${id}`)
            .then(response => Promise.resolve(response.data));
    }

    public async save(user: User) : Promise<User> {
        if(user.id != null) {
            return http.put(this.urlUserList + `${user.id}`, user)
                .then(response => Promise.resolve(response.data));
        } else {
            return http.post(this.urlUserList, user)
                .then(response => Promise.resolve(response.data));
        }
    }

    public async deleteById(id: string) : Promise<void> {
        return http.delete(this.urlUserList + `${id}`)
        .then(response => Promise.resolve(response.data));
    }
}