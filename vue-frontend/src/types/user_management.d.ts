interface Role {
    name: string;
}

interface User {
    username: string;
    role: Role
}

interface Page<T> {
    content: T[],
    number: number,
    first: boolean,
    last: boolean,
    totalElements: number,
    totalPages: number
}