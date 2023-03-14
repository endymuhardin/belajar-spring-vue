export class UserManagementService {

    private urlBase = "http://localhost:8080";
    private urlUserList = "/api/user/";

    public async findUsers() : Promise<Page<User>> {
        return fetch(this.urlBase + this.urlUserList)
                .then(response => Promise.resolve(response.json()))
    }
}